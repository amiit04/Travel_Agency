package com.travelagency.travelagency.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Agents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agentId;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    private String name;
    private String email;
    private String phone;

    @Temporal(TemporalType.DATE)
    private Date dob;

    private String address;
    private Double salary;
    private String identityType;
    private String identityNumber;
}
