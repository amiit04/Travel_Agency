package com.travelagency.travelagency.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Tours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tourId;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    private String name;
    private Double pricePerHead;
    private String duration;

    @Transient
    private List<String> locationNames;  // Temporary field to hold location names
}