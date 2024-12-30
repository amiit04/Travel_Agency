package com.travelagency.travelagency.Repo;

import com.travelagency.travelagency.entity.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepo extends JpaRepository<Locations, Long> {

    // Find a list of Locations by a list of location IDs
    List<Locations> findByLocationIdIn(List<Long> locationIds);
}