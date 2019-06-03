package com.busyqa.crm.repo;

import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.clients.Lead;
import com.busyqa.crm.model.clients.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ClientRepository implements IClientRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private IAcademicsRepository academicsRepository;

    @Override
    public void addLead(Lead lead) {
        lead.setClientStatus("Lead");
        entityManager.persist(lead);
    }

    @Override
    public List<Lead> getAllLead() {
        //note Ticket is the class name; not the table name; class name is case sensitive; use class field names - column names
        //String query = "select t from Ticket t order by t.title";
        //return (List<Ticket>) entityManager.createQuery(query).getResultList();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Lead> cq = cb.createQuery(Lead.class);
        Root<Lead> lead = cq.from(Lead.class);
        cq.select(lead).where(cb.equal(lead.get("clientStatus"), "Lead"));
        TypedQuery<Lead> q = entityManager.createQuery(cq);
        List<Lead> allTickets = q.getResultList();
        return allTickets;
    }


    @Override
    public Lead getLeadById(long id) {
        return entityManager.find(Lead.class,id);
    }

    @Override
    public void updateLead(Lead lead) {
        getUpdatedLead(lead);
        flushAndClear();
    }

    @Override
    public void deleteLeadById(long id) {
        entityManager.remove(id);
    }




    // STUDENT
    @Override
    public void copyLeadToStudent(Student student) {
        entityManager.persist(student);
    }


    @Override
    public boolean studentExists(String email) {
        String jpql = "from Student as a WHERE a.email =:email";
        int count = entityManager.createQuery(jpql).setParameter("email",email).getResultList().size();

        return count > 0;
    }


    @Override
    public boolean leadExists(String email) {
        String jpql = "from Lead as a WHERE a.email =:email";
        int count = entityManager.createQuery(jpql).setParameter("email",email).getResultList().size();

        return count > 0;
    }

    /////
    @Override
    public List<Student> getAllStudent() {
        String jpql = "SELECT j FROM Student j ORDER BY j.id";
        return (List<Student>) entityManager.createQuery(jpql)
                .getResultStream()
                .collect(Collectors.toList());
    }

    @Override
    public Student getStudentById(long id) {

        return entityManager.find(Student.class,id);
    }

    @Override
    public void updateStudent(Student student) {

        getUpdatedStudent(student);
        flushAndClear();

    }

    @Override
    public void deleteStudentById(long id) {

        entityManager.remove(id);
    }



    // HELPER METHODS

    private Lead getUpdatedLead(Lead lead) {

        Lead newLead = getLeadById(lead.getId());

        // PERSONAL INFO
        newLead.setFirstName(lead.getFirstName());
        newLead.setLastName(lead.getLastName());
        newLead.setEmail(lead.getEmail());
        newLead.setPhone(lead.getPhone());
        newLead.setEmergencyPhone(lead.getEmergencyPhone());

        // ADDRESS
        newLead.setMailingStreet(lead.getMailingStreet());
        newLead.setMailingCity(lead.getMailingCity());
        newLead.setMailingZip(lead.getMailingZip());
        newLead.setMailingState(lead.getMailingState());
        newLead.setMailingCountry(lead.getMailingCountry());

        // ACADEMICS
        newLead.setCourse(lead.getCourse());
        newLead.setPaymentPlan(lead.getPaymentPlan());
        newLead.setPaymentPlanStatus(lead.getPaymentPlanStatus());

        // EMPLOYMENT STATUS
        newLead.setComments(lead.getComments());
        newLead.setCurrentlyEmployed(lead.getCurrentlyEmployed());
        newLead.setCurrentlyITEmployed(lead.getCurrentlyITEmployed());
        newLead.setDesiredJob(lead.getDesiredJob());

        // CLIENT STATUS
        newLead.setClientStatus(lead.getClientStatus());
        newLead.setRegistrationFee(lead.getRegistrationFee());
        newLead.setLeadStatus(lead.getLeadStatus());
        newLead.setLeadSource(lead.getLeadSource());
        newLead.setRegistrationFeePaid(lead.getRegistrationFeePaid());

        return newLead;
    }

    private Student getUpdatedStudent(Student student) {

        Student student1 = getStudentById(student.getId());

        student1 = (Student) getUpdatedLead(student);

        student1.setPayments(student.getPayments());
        student1.setBalance(student.getBalance());
        student1.setTotalFee(student.getTotalFee());
        return student1;
    }


    private void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }


    public List<Lead> findLeadCourseJava() {
        String jpql = "SELECT DISTINCT j FROM Lead j JOIN j.course c WHERE c.id =:course_id ORDER BY j.id";

        return (List<Lead>) entityManager.createQuery(jpql)
                .setParameter("course_id",1)
                .getResultStream()
                .collect(Collectors.toList());
    }



    //    @Override
//    public List<Lead> getAllLead() {
//        String query1 =
//        "SELECT j FROM Lead j WHERE j.clientStatus = 'Registered' " +
//                "OR j.clientStatus = 'Interested' ORDER BY j.id";
//
//        return (List<Lead>) entityManager.createQuery(query1)
//                .getResultStream()
//                .collect(Collectors.toList());
//    }


}

