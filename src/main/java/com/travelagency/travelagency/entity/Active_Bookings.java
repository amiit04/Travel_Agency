package com.travelagency.travelagency.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Active_Bookings {
    @EmbeddedId
    private ActiveBookingsKey id;

    @ManyToOne
    @JoinColumn(name = "vehicleId", insertable = false, updatable = false)  // Foreign key to Vehicle
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "driverId", insertable = false, updatable = false)  // Foreign key to Drivers
    private Drivers driver;

    @ManyToOne
    @JoinColumn(name = "bookingId", insertable = false, updatable = false)  // Foreign key to Bookings
    private Bookings booking;

//    @ManyToOne
//    @JoinColumn(name = "driverId")
//    private Drivers driver;
//
//    @ManyToOne
//    @JoinColumn(name = "vehicleId")
//    private Vehicle vehicle;
}
