package com.travelagency.travelagency.Service;

import com.travelagency.travelagency.Repo.ClientRepo;
import com.travelagency.travelagency.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private ClientRepo clientRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepo.findByClientId(Long.valueOf(username));
        if(client != null) {
            var appuser = User.withUsername(String.valueOf(client.getClientId()))
                    .password(client.getPassword())
                    .roles("USER")
                    .build();
            return appuser;
        }
        throw new UsernameNotFoundException("User not found with ClientId: " + username);
    }
}
