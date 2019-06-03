package com.busyqa.crm.repo;

import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.clients.Lead;
import com.busyqa.crm.model.clients.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        entityManager.persist(lead);
    }

    @Override
    public List<Lead> getAllLead() {
        String query1 = "SELECT j FROM Lead j WHERE j.clientStatus = 'Registered' OR j.clientStatus = 'Interested' ORDER BY j.id";


        String query2 = "SELECT j FROM Lead j ORDER BY j.id";

        return (List<Lead>) entityManager.createQuery(query1)
                .getResultStream()
                .collect(Collectors.toList());
    }

    @Override
    public Lead getLeadById(long id) {
        return entityManager.find(Lead.class,id);
    }

    @Override
    public void updateLead(Lead lead) {
        updateLead(lead);
        flushAndClear();
    }

    @Override
    public void deleteLeadById(long id) {
        entityManager.remove(id);
    }


    // STUDENT
    @Override
    public void copyLeadToStudent(Lead lead) {
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
                newlead.getRegistrationFeePaid()
        );
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
    public Lead getStudentById(long id) {

        return entityManager.find(Lead.class,id);
    }

    @Override
    public void updateStudent(Student student) {

        getUpdatedLead(student);
        flushAndClear();

    }

    @Override
    public void deleteStudentById(long id) {

        entityManager.remove(id);
    }

    //


    private Lead getUpdatedLead(Lead lead) {

        Lead newLead = getLeadById(lead.getId());

        newLead.setFirstName(lead.getFirstName());
        newLead.setLastName(lead.getLastName());
        newLead.setEmail(lead.getEmail());
        newLead.setPhone(lead.getPhone());

        return newLead;
    }

    private Student updateStudentToLead(Lead lead) {

        Student student = new Student(getLeadById(lead.getId()));

        student.setFirstName(lead.getFirstName());
        student.setLastName(lead.getLastName());
        student.setEmail(lead.getEmail());
        student.setPhone(lead.getPhone());
        student.setEmergencyPhone(lead.getEmergencyPhone());
        student.setClientStatus(lead.getClientStatus());
        student.setRegistrationFee(lead.getRegistrationFee());
        student.setCourse(lead.getCourse());
        return student;
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

}

// Query




//