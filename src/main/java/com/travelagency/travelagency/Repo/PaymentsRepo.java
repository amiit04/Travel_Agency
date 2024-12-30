package com.travelagency.travelagency.Repo;

import com.travelagency.travelagency.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepo extends JpaRepository<Payments, Long> {
}
