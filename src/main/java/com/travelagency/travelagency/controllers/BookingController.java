package com.travelagency.travelagency.controllers;

import com.travelagency.travelagency.Repo.BookingRepo;
import com.travelagency.travelagency.Repo.ClientRepo;
import com.travelagency.travelagency.Repo.DiscountRepo;
import com.travelagency.travelagency.Repo.ToursRepo;
import com.travelagency.travelagency.entity.Bookings;
import com.travelagency.travelagency.entity.Client;
import com.travelagency.travelagency.entity.Discounts;
import com.travelagency.travelagency.entity.Tours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.format.datetime.DateFormatter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private ToursRepo toursRepo;

    @Autowired
    private DiscountRepo discountRepo;

    @GetMapping("/{tourId}")
    public String getBookingByTourId(@PathVariable Long tourId, Model model, Authentication authentication) {
        // Retrieve the tour by tourId
        Optional<Tours> tourOpt = toursRepo.findById(tourId);
        if (tourOpt.isEmpty()) {
            return "error"; // Handle invalid tourId scenario
        }
        Long clientId = Long.valueOf(authentication.getName());
        Double pricePerHead = tourOpt.get().getPricePerHead();

        // Add necessary data to the model
        model.addAttribute("tourId", tourId);
        model.addAttribute("clientId", clientId);
        model.addAttribute("currentDate", LocalDate.now().toString());
        model.addAttribute("pricePerHead", pricePerHead);

        return "booking";
    }

    private Long getLoggedInClientId() {

        return 1L;  // Placeholder for actual client ID
    }

    // DTO for receiving booking data from the form
    public static class BookingRequest {
        private Long clientId;
        private Date bookingDate;
        private Integer noOfGuests;
        private Date startDate;
        private String discountCode;

        // Getters and Setters
        public Long getClientId() {
            return clientId;
        }

        public void setClientId(Long clientId) {
            this.clientId = clientId;
        }

        public Date getBookingDate() {
            return bookingDate;
        }

        public void setBookingDate(Date bookingDate) {
            this.bookingDate = bookingDate;
        }

        public Integer getNoOfGuests() {
            return noOfGuests;
        }

        public void setNoOfGuests(Integer noOfGuests) {
            this.noOfGuests = noOfGuests;
        }

        public Date getStartDate() {
            return startDate;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }

        public String getDiscountCode() {
            return discountCode;
        }

        public void setDiscountCode(String discountCode) {
            this.discountCode = discountCode;
        }
    }
}
