package com.spring.springboot.mobile_phone_springboot.rest_controller;

import com.spring.springboot.mobile_phone_springboot.request.UserRequest;
import com.spring.springboot.mobile_phone_springboot.response.UserResponse;
import com.spring.springboot.mobile_phone_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> showAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable final int id) {
        return userService.getUser(id);
    }

    @PostMapping
    public UserResponse addNewUser(@Validated @RequestBody final UserRequest userRequest) {
        return userService.saveUser(userRequest);
    }

    @PutMapping
    public UserResponse updateUser(@Validated @RequestBody final UserRequest userRequest) {
        return userService.saveUser(userRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable final int id) {
        userService.deleteUser(id);
        return "Пользователь с ID: " + id + ", был удален";
    }
}
