package com.travelagency.travelagency.controllers;

import com.travelagency.travelagency.Repo.DiscountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/discount")
public class Ad_discountdelete
{

    @Autowired
    private DiscountRepo discountRepository;

    // Method to show all discounts on the page
    @GetMapping
    public String showDiscounts(Model model) {
        model.addAttribute("discounts", discountRepository.findAll());
        return "Ad_discount";  // View name: discounts.html
    }

    // Method to handle deletion of a discount
    @PostMapping("/delete/{id}")
    public String deleteDiscount(@PathVariable String id) {
        discountRepository.deleteById(id);
        return "redirect:/admin/discount";  // Redirect to refresh the list after deletion
    }
}