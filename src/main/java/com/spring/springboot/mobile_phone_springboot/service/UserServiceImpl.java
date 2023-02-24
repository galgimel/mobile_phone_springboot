package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.entity.User;
import com.spring.springboot.mobile_phone_springboot.repository.MobilePhoneRepository;
import com.spring.springboot.mobile_phone_springboot.repository.UserRepository;
import com.spring.springboot.mobile_phone_springboot.request.UserRequest;
import com.spring.springboot.mobile_phone_springboot.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MobilePhoneRepository mobilePhoneRepository;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository, MobilePhoneRepository mobilePhoneRepository) {
        this.userRepository = userRepository;
        this.mobilePhoneRepository = mobilePhoneRepository;
    }

    @Override
    @Transactional
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
            .map(UserResponse::of)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserResponse getUser(final int id) {
        return UserResponse.of(userRepository.getReferenceById(id));
    }

    @Override
    @Transactional
    public UserResponse saveUser(final UserRequest userRequest) {
        User user = getUserOf(userRequest);
        userRepository.save(user);
        return UserResponse.of(user);
    }

    @Override
    @Transactional
    public void deleteUser(final int id) {
        userRepository.deleteById(id);
    }

    private User getUserOf(final UserRequest userRequest) {
        User user;
        Optional<User> optional = userRepository.findById(userRequest.getId());
        user = optional.orElseGet(User::new);
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setAge(userRequest.getAge());
        if (userRequest.getMobilePhoneId() == 0) {
            user.setUsersMobilePhone(null);
        } else {
            MobilePhone mobilePhone = null;
            Optional<MobilePhone> optionalMobilePhone =
                mobilePhoneRepository.findById(userRequest.getMobilePhoneId());
            if (optionalMobilePhone.isPresent()) {
                mobilePhone = optionalMobilePhone.get();
            }
            user.setUsersMobilePhone(mobilePhone);
        }
        return user;
    }
}
