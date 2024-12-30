package com.travelagency.travelagency.Service;

import java.util.UUID;
import com.travelagency.travelagency.Repo.DiscountRepo;
import com.travelagency.travelagency.entity.*;
import com.travelagency.travelagency.Repo.BookingRepo;
import com.travelagency.travelagency.Repo.PaymentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingsRepository;

    @Autowired
    private PaymentsRepo paymentsRepository;

    @Autowired
    private DiscountRepo discountsRepository;

    public Bookings saveBooking(Client client, Tours tour, Date bookingDate, int noOfGuests, double pricePerHead, String vehicle, Date startDate, String discountCode) {
        // Calculate total cost
        double vehicleCharge = vehicle.equalsIgnoreCase("car") ? 500 : 1000;
        int cap = vehicle.equalsIgnoreCase("car") ? 4 : 10;
        double totalAmount = (pricePerHead * noOfGuests) + vehicleCharge * ((noOfGuests + cap - 1) / cap);

        Discounts discount = null;
        if (discountCode != null && !discountCode.isEmpty()) {
            discount = discountsRepository.findById(discountCode).orElse(null);
        }
        // Create and save booking
        Bookings booking = new Bookings();
        booking.setClient(client);
        booking.setTour(tour);
        booking.setBookingDate(bookingDate);
        booking.setNoOfGuests(noOfGuests);
        booking.setAmount(totalAmount);
        booking.setStatus("Pending");
        booking.setStartDate(startDate);
        booking.setDiscount(discount); // Assuming Discounts entity and mapping

        return bookingsRepository.save(booking);
    }

    public Payments savePayment(Bookings booking, String paymentMethod) {
        // Create and save payment
        String transactionId = UUID.randomUUID().toString();
        Payments payment = new Payments();
        payment.setBooking(booking);
        payment.setAmount(booking.getAmount());
        payment.setPaymentDate(new Date());
        payment.setPaymentMethod(paymentMethod);
        payment.setTransactionId(transactionId);
        return paymentsRepository.save(payment);
    }
}
