package com.busyqa.crm.service;

import com.busyqa.crm.model.clients.Lead;
import com.busyqa.crm.repo.LeadUpdateRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class LeadUpdateService {

    @Autowired
    private LeadUpdateRepositoryI leadUpdateRepositoryI;

    public void updateLeadMo(Lead lead) {
        leadUpdateRepositoryI.updateLeadMo(lead);

    }
}
