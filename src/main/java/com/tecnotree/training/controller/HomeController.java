package com.tecnotree.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "Home";
    }
    
    @GetMapping("/login")
    public String login() {
        return "Login";
    }
    
    @GetMapping("/register")
    public String register() {
        return "Register";
    }
}
