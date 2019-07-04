package com.busyqa.crm.repo;

import com.busyqa.crm.model.clients.Intern;

import javax.transaction.Transactional;

@Transactional
public interface InternRepository extends UserBaseRepository<Intern> {

}
