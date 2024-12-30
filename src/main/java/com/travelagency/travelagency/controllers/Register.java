package com.travelagency.travelagency.controllers;

import com.travelagency.travelagency.Repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Register {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ClientRepo clientRepository;

    @GetMapping("/about")
    public String show1() {
        return "about";
    }

    @GetMapping("/register")
    public String show2() {
        return "register"; // Renders register.html
    }

    @GetMapping("/review")
    public String show3() {
        return "review";
    }

    @GetMapping("/faq")
    public String show4() {
        return "faq";
    }

}