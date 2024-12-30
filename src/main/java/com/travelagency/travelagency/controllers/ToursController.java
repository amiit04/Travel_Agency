package com.travelagency.travelagency.controllers;

import com.travelagency.travelagency.Repo.LocationRepo;
import com.travelagency.travelagency.Repo.PackageRepo;
import com.travelagency.travelagency.Repo.ToursRepo;
import com.travelagency.travelagency.entity.Tours;
import com.travelagency.travelagency.entity.Locations;
import com.travelagency.travelagency.Repo.PackageRepo;
import com.travelagency.travelagency.Repo.ToursRepo;
import com.travelagency.travelagency.Repo.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ToursController {

    @Autowired
    private ToursRepo toursRepository;

    @Autowired
    private PackageRepo packagesRepository;

    @Autowired
    private LocationRepo locationsRepository;

    @GetMapping("/branch/{branchId}")
    public String getBranchPackages(@PathVariable Long branchId, Model model) {
        // Fetch all tours for the given branch
        List<Tours> tours = toursRepository.findByBranch_BranchId(branchId);

        // For each tour, fetch the associated Location IDs through Package and add the names of locations
        for (Tours tour : tours) {
            // Fetch all location IDs for the current tour using the Package repository
            List<Long> locationIds = packagesRepository.findLocationIdsByTourId(tour.getTourId());

            // Fetch all locations by the list of location IDs
            List<Locations> locations = locationsRepository.findByLocationIdIn(locationIds);

            // Extract location names from the locations
            List<String> locationNames = locations.stream()
                    .map(Locations::getLocationName)
                    .collect(Collectors.toList());

            // Set the location names to the tour object (we assume you have a setLocationNames method)
            tour.setLocationNames(locationNames);
        }

        // Add the tours to the model to render in the template
        model.addAttribute("tours", tours);
        return "packages"; // Renders packages.html
    }
}