package com.travelagency.travelagency.controllers;

import com.travelagency.travelagency.entity.Client;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String adminn (Authentication authentication) {
        Long clientId = Long.valueOf(authentication.getName());
        if(clientId <= 0)
            return "redirect:/admin/discount";
        else {
            return "adminnotfound";
        }
    }

}
