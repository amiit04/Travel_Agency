package com.travelagency.travelagency.controllers;

import com.travelagency.travelagency.Dto.ClientDTO;
import com.travelagency.travelagency.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class clientController {
    @Autowired
    private ClientService clientService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveClient(@RequestBody ClientDTO clientDTO) {
        String id = clientService.addClient(clientDTO);
        return id;
    }
}



