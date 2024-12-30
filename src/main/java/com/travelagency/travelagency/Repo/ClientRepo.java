package com.travelagency.travelagency.Repo;

import com.travelagency.travelagency.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {
    Optional<Client> findOneByClientIdAndPassword(Long id, String password);
    Client findByClientId(Long id);
}
