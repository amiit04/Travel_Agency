package com.travelagency.travelagency.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class DriversCompatibility {

    @EmbeddedId
    private DriversCompatibilityKey id;  // Composite key

    @ManyToOne
    @JoinColumn(name = "type", insertable = false, updatable = false)  // Foreign key to Vehicle
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "driverId", insertable = false, updatable = false)  // Foreign key to Drivers
    private Drivers driver;

    // Getters and Setters

    public DriversCompatibilityKey getId() {
        return id;
    }

    public void setId(DriversCompatibilityKey id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Drivers getDriver() {
        return driver;
    }

    public void setDriver(Drivers driver) {
        this.driver = driver;
    }
}
