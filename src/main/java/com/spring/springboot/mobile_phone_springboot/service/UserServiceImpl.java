package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.entity.User;
import com.spring.springboot.mobile_phone_springboot.repository.UserRepository;
import com.spring.springboot.mobile_phone_springboot.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.spring.springboot.mobile_phone_springboot.response.UserResponse.getUserResponse;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
            .map(user -> getUserResponse(user)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserResponse getUser(final int id) {
        final User user = userRepository.getReferenceById(id);
        return getUserResponse(user);
    }

    @Override
    @Transactional
    public void saveUser(final User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(final int id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public boolean usersMobilePhoneIsNull(final UserResponse user) {
        MobilePhone mobilePhone = user.getUsersMobilePhone();
        if (mobilePhone == null) {
            return true;
        } else {
            return false;
        }
    }
}
