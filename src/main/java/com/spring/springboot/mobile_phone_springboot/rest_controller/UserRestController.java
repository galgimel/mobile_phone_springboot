package com.spring.springboot.mobile_phone_springboot.rest_controller;

import com.spring.springboot.mobile_phone_springboot.entity.User;
import com.spring.springboot.mobile_phone_springboot.response.UserResponse;
import com.spring.springboot.mobile_phone_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest_user")
public class UserRestController {
    private UserService userService;
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
    public UserResponse addNewUser(@RequestBody final User user) {
        userService.saveUser(user);
        return UserResponse.of(user);
    }

    @PutMapping
    public UserResponse updateUser(@RequestBody final User user) {
        userService.saveUser(user);
        return UserResponse.of(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable final int id) {
        userService.deleteUser(id);
        return "Пользователь был удален";
    }
}
