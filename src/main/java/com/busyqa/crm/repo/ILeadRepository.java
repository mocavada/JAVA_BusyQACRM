package com.busyqa.crm.repo;

import com.busyqa.crm.model.clients.Lead;

import java.util.List;

public interface ILeadRepository {
    List<Lead> getAllLeads();
    void addLead(Lead lead);
    Lead getLeadById(long id);
    void updateLead(Lead lead);
    void deleteLeadById(int id);
    void copyLeadToStudent(Lead lead);

}
