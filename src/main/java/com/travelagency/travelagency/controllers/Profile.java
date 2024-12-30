package com.travelagency.travelagency.controllers;

import com.travelagency.travelagency.Repo.ClientRepo;
import com.travelagency.travelagency.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Profile {

    @Autowired
    private ClientRepo userService;

//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    String getUser = authentication.getName();  // Assuming username is used as the client ID
//    Client user = userService.findByClientId(Long.valueOf(getUser));

    @GetMapping("/profile")
    public String getUserProfile(Model model , Authentication authentication) {
        String clientId = authentication.getName();
        // Fetch user data from the repository
        Client user = userService.findByClientId(Long.valueOf(clientId));
        // Add the client object to the model with attribute name 'client'
        model.addAttribute("client", user);
        // Return the view name (profile.html in templates directory)
        return "profile";
    }
}
