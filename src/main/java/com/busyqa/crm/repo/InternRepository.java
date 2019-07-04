package com.busyqa.crm.repo;

import com.busyqa.crm.model.clients.Intern;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface InternRepository extends UserBaseRepository<Intern> {

    Optional<Intern> findByEmail(String email);

}
