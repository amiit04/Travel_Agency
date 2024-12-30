package com.travelagency.travelagency.Service;

import com.travelagency.travelagency.Dto.ClientDTO;
import com.travelagency.travelagency.Repo.ClientRepo;
import com.travelagency.travelagency.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientIMPL implements ClientService {

    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addClient(ClientDTO clientDTO) {
        Client client = new Client(
                clientDTO.getName(),
                clientDTO.getEmail(),
                clientDTO.getPhone(),
                clientDTO.getAddress(),
                clientDTO.getDob(),
                clientDTO.getIdentityType(),
                clientDTO.getIdentityNumber(),
                clientDTO.getNationality(),
                this.passwordEncoder.encode(clientDTO.getPassword())
        );
        clientRepo.save(client);
        return String.valueOf(client.getClientId());
    }
}