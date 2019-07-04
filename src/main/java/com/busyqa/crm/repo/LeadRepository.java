package com.busyqa.crm.repo;

import com.busyqa.crm.model.clients.Lead;

import javax.transaction.Transactional;

@Transactional
public interface LeadRepository extends UserBaseRepository<Lead> {

}




