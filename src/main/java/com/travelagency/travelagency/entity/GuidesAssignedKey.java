package com.travelagency.travelagency.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GuidesAssignedKey implements Serializable {

    private Long bookingId; // Foreign key reference to Booking entity
    private Long guideId;   // Foreign key reference to Guides entity

    // Getters and Setters
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getGuideId() {
        return guideId;
    }

    public void setGuideId(Long guideId) {
        this.guideId = guideId;
    }

    // Override equals() and hashCode() for composite key comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuidesAssignedKey that = (GuidesAssignedKey) o;
        return Objects.equals(bookingId, that.bookingId) &&
                Objects.equals(guideId, that.guideId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, guideId);
    }
}
