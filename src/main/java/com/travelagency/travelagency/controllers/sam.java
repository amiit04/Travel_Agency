package com.travelagency.travelagency.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class sam {

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("message", "Welcome to our website!");
        System.out.println("message");
        return "sam"; // Thymeleaf template name (greeting.html)
    }
}