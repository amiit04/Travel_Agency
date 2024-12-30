package com.travelagency.travelagency.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Guides_Assigned {

    @EmbeddedId
    private GuidesAssignedKey id;

    @ManyToOne
    @MapsId("bookingId") // Maps the bookingId from the embedded key
    @JoinColumn(name = "booking_id")
    private Bookings booking; // Reference to the Booking entity

    @ManyToOne
    @MapsId("guideId") // Maps the guideId from the embedded key
    @JoinColumn(name = "guide_id")
    private Guides guide; // Reference to the Guides entity
}
