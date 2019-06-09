package com.busyqa.crm.repo;

import com.busyqa.crm.model.clients.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientJpaRepository extends JpaRepository<Client, Integer> {

    Optional<Client> findByEmail(String email);
}
