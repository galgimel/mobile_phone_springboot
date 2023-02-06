package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.entity.User;
import com.spring.springboot.mobile_phone_springboot.repository.UserRepository;
import com.spring.springboot.mobile_phone_springboot.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.spring.springboot.mobile_phone_springboot.response.UserResponse.getUserResponse;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public List<UserResponse> getAllUsers() {
        final List<User> users = userRepository.findAll();
        final List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            userResponses.add(getUserResponse(user));
        }
        return userResponses;
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
}
