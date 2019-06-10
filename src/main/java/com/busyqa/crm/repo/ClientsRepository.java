package com.busyqa.crm.repo;


import com.busyqa.crm.model.clients.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Transactional
@Repository
public class ClientsRepository implements IClientsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addClient(Client client) {
        client.setClientStatus("Lead");
        entityManager.persist(client);
    }

    @Override
    public List<Client> getAllClient() {
        String jpql = "SELECT c FROM Client c ORDER BY c.id";
        return (List<Client>) entityManager.createQuery(jpql)
                .getResultStream()
                .collect(Collectors.toList());
    }

    @Override
    public Client getClientById(int id) {
        return entityManager.find(Client.class, id);
    }

    @Override
    public Client getClientByEmail(String email) {
        Client client = entityManager
                .createQuery("SELECT u from Client u WHERE u.email = :email", Client.class)
                .setParameter("email", email)
                .getSingleResult();
        return client;
    }

    @Override
    public List<Client> getAllLead() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> cq = cb.createQuery(Client.class);
        Root<Client> client = cq.from(Client.class);

        cq.select(client).where(cb.equal(client.get("clientStatus"), "Lead"));
        TypedQuery<Client> q = entityManager.createQuery(cq);
        List<Client> allLeads = q.getResultList();
        return allLeads;
    }

    @Override
    public List<Client> getAllStudent() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> cq = cb.createQuery(Client.class);
        Root<Client> client = cq.from(Client.class);

        cq.select(client).where(cb.equal(client.get("clientStatus"), "Student"));
        TypedQuery<Client> q = entityManager.createQuery(cq);
        List<Client> allStudents = q.getResultList();
        return allStudents;
    }

    @Override
    public void deleteClientById(long id) {
        entityManager.remove(id);
    }

    @Override
    public boolean clientExist(String email) {
        String jpql = "from Client as a WHERE a.email =: email";
        int count = entityManager.createQuery(jpql)
                .setParameter("email",email)
                .getResultList().size();
        return count > 0;
    }




    // FOR DELETE ?
//    @Override
//    public void saveLeadToStudent(Client client) {
//
//        Client newClient = getClientById(client.getId());
//        Client student = getUpdatedLead(newClient);
//        student.setClientStatus("Student");
//        flushAndClear();
//        entityManager.merge(client);
//    }

//    @Override
//    public void updateStudent(Client client) {
//        getUpdatedStudent(client);
//        flushAndClear();
//    }


    //////////////////
    // HELPER METHODS
    //////////////////

//    private Client getUpdatedLead(Client client) {
//
//        Client lead = getClientById(client.getId());
//
//        // PERSONAL INFO
//        lead.setClientStatus("Lead");
//        lead.setFirstName(client.getFirstName());
//        lead.setLastName(client.getLastName());
//        lead.setEmail(client.getEmail());
//        lead.setPhone(client.getPhone());
//        lead.setEmergencyPhone(client.getEmergencyPhone());
//
//        // ADDRESS
//        lead.setMailingStreet(client.getMailingStreet());
//        lead.setMailingCity(client.getMailingCity());
//        lead.setMailingZip(client.getMailingZip());
//        lead.setMailingState(client.getMailingState());
//        lead.setMailingCountry(client.getMailingCountry());
//
//        // ACADEMICS
//        lead.setCourse(client.getCourse());
//        lead.setPaymentPlan(client.getPaymentPlan());
//        lead.setPaymentPlanStatus(client.getPaymentPlanStatus());
//
//        // EMPLOYMENT STATUS
//        lead.setComments(client.getComments());
//        lead.setCurrentlyEmployed(client.getCurrentlyEmployed());
//        lead.setCurrentlyITEmployed(client.getCurrentlyITEmployed());
//        lead.setDesiredJob(client.getDesiredJob());
//
//        // STATUS
//        lead.setRegistrationFee(client.getRegistrationFee());
//        lead.setLeadStatus(client.getLeadStatus());
//        lead.setLeadSource(client.getLeadSource());
//        lead.setRegistrationFeePaid(client.getRegistrationFeePaid());
//
//        return lead;
//    }


//    private Client getUpdatedStudent(Client client) {
//
//        Client student = getClientById(client.getId());
//
//        // PERSONAL INFO
//        student.setFirstName(client.getFirstName());
//        student.setLastName(client.getLastName());
//        student.setEmail(client.getEmail());
//        student.setPhone(client.getPhone());
//        student.setEmergencyPhone(client.getEmergencyPhone());
//
//        // ADDRESS
//        student.setMailingStreet(client.getMailingStreet());
//        student.setMailingCity(client.getMailingCity());
//        student.setMailingZip(client.getMailingZip());
//        student.setMailingState(client.getMailingState());
//        student.setMailingCountry(client.getMailingCountry());
//
//        // ACADEMICS
//        student.setPaymentPlan(client.getPaymentPlan());
//        student.setPaymentPlanStatus(client.getPaymentPlanStatus());
//
//
//        // CLIENT STATUS
//
//        student.setRegistrationFee(client.getRegistrationFee());
//        student.setLeadStatus(client.getLeadStatus());
//        student.setLeadSource(client.getLeadSource());
//        student.setRegistrationFeePaid(client.getRegistrationFeePaid());
//
//        student.setTotalFee(client.getTotalFee());
//        student.setBalance(client.getBalance());
//        student.setPayments(client.getPayments());
//
//        return student;
//    }
//
//    private void flushAndClear() {
//        entityManager.flush();
//        entityManager.clear();
//
//    }

}



