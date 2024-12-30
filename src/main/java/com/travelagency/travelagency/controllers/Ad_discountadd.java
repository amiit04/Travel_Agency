package com.travelagency.travelagency.controllers;

import com.travelagency.travelagency.Repo.DiscountRepo;
import com.travelagency.travelagency.entity.Discounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Date;

@Controller
@RequestMapping("/admin/discounts")
public class Ad_discountadd {

    @Autowired
    private DiscountRepo discountRepo;

    // Handle GET request to display the form for adding a new discount
    @GetMapping("/add")
    public String showAddDiscountForm(Model model) {
        // Initialize a new Discounts object to bind to the form
        //model.addAttribute("discount", new Discounts());
        return "Add"; // The name of the Thymeleaf template (Add.html)
    }

    // Handle POST request to save the discount data to the database
    @PostMapping("/add")
    public String addDiscount(@RequestParam("discountCode") String discountCode,
                              @RequestParam("description") String description,
                              @RequestParam("percentage") Double percentage,
                              @RequestParam("validFrom") @DateTimeFormat(pattern = "yyyy-MM-dd") Date validFrom,
                              @RequestParam("validTo") @DateTimeFormat(pattern = "yyyy-MM-dd") Date validTo,
                              @RequestParam("minPurchaseAmount") Double minPurchaseAmount) {

        Discounts discount = new Discounts();
        discount.setDiscountCode(discountCode);
        discount.setDescription(description);
        discount.setPercentage(percentage);
        discount.setValidFrom(validFrom);
        discount.setValidTo(validTo);
        discount.setMinPurchaseAmount(minPurchaseAmount);
        discountRepo.save(discount);

        return "redirect:/admin/discount";  // Assuming you have a page to list discounts
    }

}