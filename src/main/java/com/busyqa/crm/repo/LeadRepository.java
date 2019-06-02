package com.busyqa.crm.repo;

import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.clients.Lead;
import com.busyqa.crm.model.clients.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Repository
public class LeadRepository implements ILeadRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Lead> getAllLeads() {
        String jpql = "SELECT j FROM Lead j ORDER BY j.id";

        return (List<Lead>) entityManager.createQuery(jpql)
                .getResultStream()
                .collect(Collectors.toList());
    }

    @Override
    public Lead getLeadById(long id) {
        return entityManager.find(Lead.class,id);
    }

    @Override
    public void addLead(Lead lead) {
        entityManager.persist(lead);
    }


    @Override
    public void updateLead(Lead lead) {
        Lead updateLead = getLeadById(lead.getId());
        updateLead.setFirstName(lead.getFirstName());
        updateLead.setLastName(lead.getLastName());
        updateLead.setPhone(lead.getPhone());
        updateLead.setEmail(lead.getEmail());
        updateLead.setStatus(lead.getStatus());
        updateLead.setLeadSource(lead.getLeadSource());
        updateLead.setComments(lead.getComments());
        updateLead.setRegistrationFee(lead.getRegistrationFee());
        updateLead.setCourse(lead.getCourse());
        entityManager.flush();

    }

    @Override
    public void deleteLeadById(int id) {
        entityManager.remove(id);
    }

    @Override
    public void copyLeadToStudent(Lead lead) {

        Student student = new Student();
        Lead copyLead = getLeadById(lead.getId());
        BeanUtils.copyProperties(student, copyLead);

        entityManager.persist(student);

    }


}

