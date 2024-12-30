package com.travelagency.travelagency.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ActiveBookingsKey implements Serializable {

    private Long bookingId;  // Foreign key reference to Booking entity
    private Long driverId;   // Foreign key reference to Driver entity
    private Long vehicleId;  // Foreign key reference to Vehicle entity

    // Getters and Setters
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    // Override equals() and hashCode() for composite key comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActiveBookingsKey that = (ActiveBookingsKey) o;
        return Objects.equals(bookingId, that.bookingId) &&
                Objects.equals(driverId, that.driverId) &&
                Objects.equals(vehicleId, that.vehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, driverId, vehicleId);
    }
}
