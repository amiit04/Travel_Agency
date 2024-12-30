package com.travelagency.travelagency.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DriversCompatibilityKey implements Serializable {

    private String type;
    private Long driverId;

    // Getters, Setters, hashCode, equals

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriversCompatibilityKey that = (DriversCompatibilityKey) o;
        return Objects.equals(type, that.type) && Objects.equals(driverId, that.driverId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, driverId);
    }
}
