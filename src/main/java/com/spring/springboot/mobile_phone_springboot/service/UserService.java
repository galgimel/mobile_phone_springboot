package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.request.UserRequest;
import com.spring.springboot.mobile_phone_springboot.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();

    UserResponse getUser(int id);

    UserResponse saveUser(UserRequest userRequest);

    void deleteUser(int id);
}
