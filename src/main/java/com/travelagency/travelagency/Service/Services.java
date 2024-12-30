package com.travelagency.travelagency.Service;

import com.travelagency.travelagency.Repo.ClientRepo;
import com.travelagency.travelagency.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {

    @Autowired
    private ClientRepo userRepository;

    public Client getUserById(Long clientId) {
        return userRepository.findById(clientId).orElse(null);
    }
}