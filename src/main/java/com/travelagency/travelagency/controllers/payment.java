package com.travelagency.travelagency.controllers;

import com.travelagency.travelagency.Repo.BookingRepo;
import com.travelagency.travelagency.Repo.ClientRepo;
import com.travelagency.travelagency.Repo.DiscountRepo;
import com.travelagency.travelagency.Repo.ToursRepo;
import com.travelagency.travelagency.entity.*;
import com.travelagency.travelagency.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
public class payment {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private DiscountRepo discountRepo;

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private ToursRepo toursRepo;

    @Autowired
    private BookingRepo bookingRepo;

//    @PostMapping
//    public String processBooking(
//            @RequestParam("client") Client client,
//            @RequestParam("tourId") Tours tour,
//            @RequestParam("bookingDate") Date bookingDate,
//            @RequestParam("noOfGuests") int noOfGuests,
//            @RequestParam("vehicle") String vehicle,
//            @RequestParam("startDate") Date startDate,
//            @RequestParam("discountCode") String discountCode,
//            @RequestParam("priceperhead") double pricePerHead,
//            Model model
//    ) {
//        // Save booking and calculate cost
//        Bookings booking = bookingService.saveBooking(client, tour, bookingDate, noOfGuests, pricePerHead, vehicle, startDate, discountCode);
//
//        // Redirect to the payment page with calculated cost
//        model.addAttribute("booking", booking);
//        return "Payment";  // Render Payment.html
//    }

    @PostMapping("/payment")
    public String createBooking(@RequestParam String clientId,
                                @RequestParam Long tourId,
                                @RequestParam String bookingDate,  // Get the date as String
                                @RequestParam Integer noOfGuests,
                                @RequestParam String vehicle,
                                @RequestParam String startDate,   // Get the start date as String
                                @RequestParam(required = false) String discountCode,
                                @RequestParam Double pricePerHead,
                                @RequestParam String paymentMethod,
                                Model model) throws Exception {

        // Parse the booking date and start date using SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Parse the string dates into Date objects
        Date parsedBookingDate = sdf.parse(bookingDate);
        Date parsedStartDate = sdf.parse(startDate);

        // Calculate the base cost
        int cap = vehicle.equalsIgnoreCase("car") ? 4 : 10;
        double baseCost = pricePerHead * noOfGuests + (vehicle.equalsIgnoreCase("car") ? 500 : 1000) * ((noOfGuests + cap - 1) / cap);

        // Retrieve discount (if applicable)
        Discounts discount = null;
        if (discountCode != null && !discountCode.isEmpty()) {
            discount = discountRepo.findById(discountCode).orElse(null);
            if (discount != null && baseCost >= discount.getMinPurchaseAmount()) {
                double discountAmount = baseCost * (discount.getPercentage() / 100);
                baseCost -= discountAmount;
            }
        }

        // Retrieve client and tour entities
        Optional<Client> clientOpt = clientRepo.findById(Long.valueOf(clientId));
        Optional<Tours> tourOpt = toursRepo.findById(tourId);

        if (clientOpt.isEmpty() || tourOpt.isEmpty()) {
            return "error"; // Handle error when client or tour is not found
        }

        // Create and save the booking
        Bookings booking = new Bookings();
        booking.setClient(clientOpt.get());
        booking.setTour(tourOpt.get());
        booking.setBookingDate(parsedBookingDate);
        booking.setNoOfGuests(noOfGuests);
        booking.setAmount(baseCost);
        booking.setStatus("Pending");
        booking.setStartDate(parsedStartDate);
        booking.setDiscount(discount);
        bookingRepo.save(booking);
        bookingService.savePayment(booking, paymentMethod);

        // Set attributes for the payment page
        model.addAttribute("totalCost", baseCost);
        model.addAttribute("clientId", clientId);
        model.addAttribute("tourId", tourId);
        model.addAttribute("name", toursRepo.findName(tourId));
        model.addAttribute("bookingDate", parsedBookingDate);
        model.addAttribute("noOfGuests", noOfGuests);
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("startDate", parsedStartDate);
        model.addAttribute("discountCode", discountCode);
        model.addAttribute("paymentMethod", paymentMethod);

        return "payment";
    }
}
