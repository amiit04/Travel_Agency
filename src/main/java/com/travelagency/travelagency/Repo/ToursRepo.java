package com.travelagency.travelagency.Repo;

import com.travelagency.travelagency.entity.Tours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToursRepo extends JpaRepository<Tours, Long> {

    // Custom query to fetch all Tours for a specific branch
    @Query("SELECT t FROM Tours t JOIN FETCH t.branch b WHERE b.branchId = :branchId")
    List<Tours> findByBranch_BranchId(Long branchId);

    // Query to fetch all Location IDs associated with a specific Tour
    @Query("SELECT p.location.locationId FROM Package p WHERE p.tour.tourId = :tourId")
    List<Long> findLocationIdsByTourId(Long tourId);

    @Query("SELECT t.pricePerHead FROM Tours t WHERE t.tourId = :tourId")
    Double findPricePerHead(Long tourId);

    @Query("SELECT t.name FROM Tours t WHERE t.tourId = :tourId")
    String findName(Long tourId);


}