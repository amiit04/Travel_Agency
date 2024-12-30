package com.travelagency.travelagency.Service;

import com.travelagency.travelagency.Repo.ToursRepo;
import com.travelagency.travelagency.entity.Tours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToursService {

    private final ToursRepo toursRepository;

    @Autowired
    public ToursService(ToursRepo toursRepository) {
        this.toursRepository = toursRepository;
    }

    public List<Tours> getToursByBranchId(Long branchId) {
        return toursRepository.findByBranch_BranchId(branchId);
    }
    public Double getPricePerHeadByTourId(Long TourId) { return toursRepository.findPricePerHead(TourId);};

}