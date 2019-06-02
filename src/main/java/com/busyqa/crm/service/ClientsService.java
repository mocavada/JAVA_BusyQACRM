package com.busyqa.crm.service;

import com.busyqa.crm.model.clients.Lead;
import com.busyqa.crm.model.clients.Student;
import com.busyqa.crm.repo.ILeadRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.rmi.StubNotFoundException;
import java.util.List;

@Transactional
@Service
public class ClientsService {

    @Autowired
    private ILeadRepository leadRepository;

    /**
     * @return
     */
    public List<Lead> getAllLeads() {

        return leadRepository.getAllLeads();
    }

    /**
     * @param lead
     */
    public void addLead(Lead lead) {

        leadRepository.addLead(lead);
    }

    /**
     * @param lead
     */
    public void updateLead(Lead lead) {

        leadRepository.updateLead(lead);
    }

    /**
     * @param id
     * @return
     */
    public Lead getLeadById(long id) {

        return leadRepository.getLeadById(id);
    }

    /**
     * @param id
     */
    public void deleteLeadById(int id) {

        leadRepository.deleteLeadById(id);
    }

    /**
     * @param lead
     */
    public void copyLeadToStudent(Lead lead)  {

        leadRepository.copyLeadToStudent(lead);

    }


}
