package com.travelagency.travelagency.Repo;

import com.travelagency.travelagency.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Bookings, Long> {
}