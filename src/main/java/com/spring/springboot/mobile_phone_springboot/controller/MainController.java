package com.spring.springboot.mobile_phone_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String backToFirstView() {
        return "first-view";
    }
}
