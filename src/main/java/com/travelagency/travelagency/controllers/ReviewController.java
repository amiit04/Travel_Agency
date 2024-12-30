package com.travelagency.travelagency.controllers;

import com.travelagency.travelagency.Repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReviewController {

    @Autowired
    private ReviewRepo reviewRepo;

    @PostMapping("/review")
    public String addReview() {

        return "redirect:/";  // Redirect to refresh the list after deletion
    }
}
