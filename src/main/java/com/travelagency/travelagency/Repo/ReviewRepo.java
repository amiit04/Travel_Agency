package com.travelagency.travelagency.Repo;

import com.travelagency.travelagency.entity.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Reviews, Long> {

    // Custom query methods can be added if needed

    // Find reviews by client ID
    List<Reviews> findByClient_ClientId(Long clientId);

    // Find reviews by booking ID
    List<Reviews> findByBooking_BookingId(Long bookingId);

    // Find reviews by rating
    List<Reviews> findByRating(Integer rating);

    // Find reviews by date range
    List<Reviews> findByReviewDateBetween(Date startDate, Date endDate);
}