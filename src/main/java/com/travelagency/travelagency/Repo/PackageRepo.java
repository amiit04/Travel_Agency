package com.travelagency.travelagency.Repo;

import com.travelagency.travelagency.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepo extends JpaRepository<Package, Long> {

    // Query to fetch all location IDs associated with a specific Tour ID
    @Query("SELECT p.location.locationId FROM Package p WHERE p.tour.tourId = :tourId")
    List<Long> findLocationIdsByTourId(Long tourId);
}