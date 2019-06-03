package com.busyqa.crm.service;

import com.busyqa.crm.model.clients.Lead;
import com.busyqa.crm.model.clients.Student;
import com.busyqa.crm.repo.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ClientsService {

    @Autowired
    private IClientRepository clientRepository;


    // LEAD //
    public List<Lead> getAllLeads() { return clientRepository.getAllLead(); }

//    public void addCourse(Long courseId, Long leadId) {
//        clientRepository.addCourse(courseId,leadId);
//    }

    public synchronized boolean addLead(Lead lead) {

        if (clientRepository.leadExists(lead.getEmail())) {
            return false;
        } else {
            clientRepository.addLead(lead);
            return true;
        }
    }

    public void updateLead(Lead lead) { clientRepository.updateLead(lead); }
    public Lead getLeadById(long id) { return clientRepository.getLeadById(id); }
    public void deleteLeadById(long id) { clientRepository.deleteLeadById(id); }


    // STUDENT //
    public synchronized boolean copyLeadToStudent(Lead lead)  {
        Lead newlead = getLeadById(lead.getId());

        Student student = new Student(
            newlead.getFirstName(),
            newlead.getLastName(),
            newlead.getEmail(),
            newlead.getPhone(),
            newlead.getEmergencyPhone(),
            newlead.getClientStatus(),
            newlead.getRegistrationFee(),
            newlead.getCourse(),
            newlead.getCreatedTime(),
            newlead.getModifiedTime(),
            newlead.getLastActivityTime(),
            newlead.getLeadStatus(),
            newlead.getLeadSource(),
            newlead.getComments(),
            newlead.getCurrentlyEmployed(),
            newlead.getCurrentlyITEmployed(),
            newlead.getDesiredJob(),
            newlead.getMailingCity(),
            newlead.getMailingCountry(),
            newlead.getMailingState(),
            newlead.getMailingStreet(),
            newlead.getMailingZip(),
            newlead.getPaymentPlan(),
            newlead.getPlanAgreement(),
            newlead.getPaymentPlanStatus(),
            newlead.getRegistrationFeePaid());

        if (clientRepository.studentExists(student.getEmail())) {
            return false;
        } else {
            clientRepository.copyLeadToStudent(student);
            return true;
        }
    }


    public List<Student> getAllStudent() { return clientRepository.getAllStudent(); }

}

