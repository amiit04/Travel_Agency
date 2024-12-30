package com.travelagency.travelagency.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Guides {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guideId;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    private String name;
    private String email;
    private String phone;
    private String address;

    @Temporal(TemporalType.DATE)
    private Date dob;

    private String language;
    private Integer experience;
    private Double salary;
    private String identityType;
    private String identityNumber;
}
