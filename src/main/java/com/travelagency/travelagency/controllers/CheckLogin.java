package com.travelagency.travelagency.controllers;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckLogin {
    @GetMapping("/user")
    public String getUser(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            return "User is logged in as: " + userDetails.getUsername();
        } else {
            return "User is not logged in.";
        }
    }
}