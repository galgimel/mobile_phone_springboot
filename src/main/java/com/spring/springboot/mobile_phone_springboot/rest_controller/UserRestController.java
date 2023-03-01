package com.spring.springboot.mobile_phone_springboot.rest_controller;

import com.spring.springboot.mobile_phone_springboot.request.UserRequest;
import com.spring.springboot.mobile_phone_springboot.response.UserResponse;
import com.spring.springboot.mobile_phone_springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(final UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get list of all users")
    @GetMapping
    public List<UserResponse> showAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Get user by it's id")
    @GetMapping("/{id}")
    public UserResponse getUser(
        @Parameter(description = "id of user to search")
        @PathVariable final int id
    ) {
        return userService.getUser(id);
    }

    @Operation(summary = "Add new user")
    @PostMapping
    public UserResponse addNewUser(@RequestBody final UserRequest userRequest) {
        return userService.saveUser(userRequest);
    }

    @Operation(summary = "Update user")
    @PutMapping
    public UserResponse updateUser(@RequestBody final UserRequest userRequest) {
        return userService.saveUser(userRequest);
    }

    @Operation(summary = "Delete user by it's id")
    @DeleteMapping("/{id}")
    public String deleteUser(
        @Parameter(description = "id of user to delete")
        @PathVariable final int id
    ) {
        userService.deleteUser(id);
        return "Пользователь с ID: " + id + ", был удален";
    }
}
