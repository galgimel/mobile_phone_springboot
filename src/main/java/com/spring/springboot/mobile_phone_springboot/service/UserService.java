package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.entity.User;
import com.spring.springboot.mobile_phone_springboot.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();

    UserResponse getUser(int id);

    void saveUser(User user);

    void deleteUser(int id);
}
