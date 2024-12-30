package com.travelagency.travelagency.Repo;

import com.travelagency.travelagency.entity.Discounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface DiscountRepo extends JpaRepository<Discounts, String> {

    // Custom query methods can be added if needed, for example:
    Discounts findByDiscountCode(String discountCode);

    // Optional: Find discounts that are currently valid
    List<Discounts> findByValidFromBeforeAndValidToAfter(Date validFrom, Date validTo);
}