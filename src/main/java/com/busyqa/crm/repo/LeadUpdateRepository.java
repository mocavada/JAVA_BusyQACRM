package com.busyqa.crm.repo;

import com.busyqa.crm.model.clients.Lead;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class LeadUpdateRepository implements LeadUpdateRepositoryI {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Lead getLeadByEmail(String email) {

        Lead lead = entityManager.createQuery(
                "SELECT u from Lead u WHERE u.email = :email", Lead.class).
                setParameter("email", email).getSingleResult();
        return lead;
    }

    @Override
    public void updateLeadMo(Lead lead) {


        Lead l = getLeadById(lead.getId());

        l.setFirstName(lead.getFirstName());
        l.setLastName(lead.getLastName());
        l.setPhoneNumber(lead.getPhoneNumber());
        l.setEmergencyPhone(lead.getEmergencyPhone());

        l.setClientStatus(lead.getClientStatus());
        l.setLeadSource(lead.getLeadSource());
        l.setComments(lead.getComments());
        l.setCurrentlyEmployed(lead.getCurrentlyEmployed());
        l.setCurrentlyITEmployed(lead.getCurrentlyITEmployed());
        l.setDesiredJob(l.getDesiredJob());

        l.setMailingStreet(lead.getMailingStreet());
        l.setMailingCity(lead.getMailingCity());
        l.setMailingState(lead.getMailingState());
        l.setMailingZip(lead.getMailingZip());
        l.setMailingCountry(lead.getMailingCountry());

        l.setRegistrationFeePaid(lead.getRegistrationFeePaid());
        l.setPlanAgreementSigned(lead.getPlanAgreementSigned());
        l.setDiscountGiven(lead.getDiscountGiven());


        // Academics
        l.setCourse(lead.getCourse());
        l.setTotalCourseFee(lead.getTotalCourseFee());

        l.setCourseSchedule(lead.getCourseSchedule());
        l.setTrainer(lead.getTrainer());
        l.setTrainingLocation(lead.getTrainingLocation());

        // Finance
        l.setRegistrationFee(lead.getRegistrationFee());
        l.setDiscount(lead.getDiscount());
        l.setPaymentPlan(lead.getPaymentPlan());

        entityManager.flush();

    }

    @Override
    public Lead getLeadById(long id) {
        return entityManager.find(Lead.class, id);
    }
}
