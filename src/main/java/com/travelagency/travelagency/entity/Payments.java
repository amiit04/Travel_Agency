package com.travelagency.travelagency.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Bookings booking;

    private Double amount;

    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    private String paymentMethod;

    private String transactionId;
}
