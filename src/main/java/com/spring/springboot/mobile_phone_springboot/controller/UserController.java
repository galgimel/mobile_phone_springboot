package com.spring.springboot.mobile_phone_springboot.controller;

import com.spring.springboot.mobile_phone_springboot.entity.User;
import com.spring.springboot.mobile_phone_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAllUsers(final Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());

        return "/user/all-users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable final int id, final Model model) {
        model.addAttribute("user", userService.getUser(id));

        return "/user/user-profile";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(@ModelAttribute("user") final User user) {

        return "/user/user-create";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") final User user) {
        userService.saveUser(user);

        return "redirect:/users";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") final int id, final Model model) {
        model.addAttribute("user", userService.getUser(id));

        return "/user/user-update";
    }

    @PutMapping("/{id}")
    public String saveUpdatedUser(@ModelAttribute("user") final User user) {
        userService.saveUser(user);

        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") final int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}