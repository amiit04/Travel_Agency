package com.travelagency.travelagency.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Discounts {
    @Id
    private String discountCode;

    private String description;
    private Double percentage;

    @Temporal(TemporalType.DATE)
    private Date validFrom;

    @Temporal(TemporalType.DATE)
    private Date validTo;

    private Double minPurchaseAmount;
}
