package com.travelagency.travelagency.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Guests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guestsId;

    private String name;
    private String email;
    private String phone;

    @Temporal(TemporalType.DATE)
    private Date dob;

    private String address;
    private String nationality;
    private String identityType;
    private String identityNumber;
}
