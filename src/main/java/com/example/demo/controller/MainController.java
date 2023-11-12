package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller

public class MainController {
    @GetMapping("/")
    public String home(Model model, Principal principal){
        if (principal != null){
            model.addAttribute("principal", principal.getName());
        }
        return "main page";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("user", new User());
        return "login";
    }



}
