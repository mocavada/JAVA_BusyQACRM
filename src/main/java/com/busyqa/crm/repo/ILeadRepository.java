package com.busyqa.crm.repo;

import com.busyqa.crm.model.clients.Lead;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface ILeadRepository extends IUserBaseRepository<Lead> {

    Optional<Lead> findByEmail(String email);
    Optional<Lead> findById(Long id);
}
