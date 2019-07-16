package com.busyqa.crm.repo;

import com.busyqa.crm.model.clients.Lead;

public interface LeadUpdateRepositoryI {

    Lead getLeadByEmail(String email);
    void updateLeadMo(Lead lead);
    Lead getLeadById(long id);
}
