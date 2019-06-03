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
public class ClientRepository implements IClientRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addClient(Client client) {
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
    public Client getClientById(long id) {
        return entityManager.find(Client.class,id);
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
    public void updateLead(Client client) {
        getUpdatedLead(client);
        flushAndClear();
    }

    @Override
    public void updateStudent(Client client) {
        getUpdatedLead(client);
        flushAndClear();
    }

    @Override
    public void deleteClientById(long id) {
        entityManager.remove(id);
    }

    @Override
    public boolean clientExist(String email) {
        String jpql = "from Student as a WHERE a.email =:email";
        int count = entityManager.createQuery(jpql)
                .setParameter("email",email)
                .getResultList().size();
        return count > 0;
    }

    // HELPER METHODS
    private Client getUpdatedLead(Client client) {

        Client newClient = getClientById(client.getId());

        // PERSONAL INFO
        newClient.setFirstName(client.getFirstName());
        newClient.setLastName(client.getLastName());
        newClient.setEmail(client.getEmail());
        newClient.setPhone(client.getPhone());
        newClient.setEmergencyPhone(client.getEmergencyPhone());

        // ADDRESS
        newClient.setMailingStreet(client.getMailingStreet());
        newClient.setMailingCity(client.getMailingCity());
        newClient.setMailingZip(client.getMailingZip());
        newClient.setMailingState(client.getMailingState());
        newClient.setMailingCountry(client.getMailingCountry());

        // ACADEMICS
        newClient.setCourse(client.getCourse());
        newClient.setPaymentPlan(client.getPaymentPlan());
        newClient.setPaymentPlanStatus(client.getPaymentPlanStatus());

        // EMPLOYMENT STATUS
        newClient.setComments(client.getComments());
        newClient.setCurrentlyEmployed(client.getCurrentlyEmployed());
        newClient.setCurrentlyITEmployed(client.getCurrentlyITEmployed());
        newClient.setDesiredJob(client.getDesiredJob());

        // CLIENT STATUS
        newClient.setClientStatus(client.getClientStatus());
        newClient.setRegistrationFee(client.getRegistrationFee());
        newClient.setLeadStatus(client.getLeadStatus());
        newClient.setLeadSource(client.getLeadSource());
        newClient.setRegistrationFeePaid(client.getRegistrationFeePaid());

        return newClient;
    }


    private void flushAndClear() {
        entityManager.flush();
        entityManager.clear();

    }

}








//    @Autowired
//    private IAcademicsRepository academicsRepository;
//
//    @Override
//    public void addLead(Client client) {
//        client.setClientStatus("Client");
//        entityManager.persist(client);
//    }
//
//    @Override
//    public List<Client> getAllClient() {
//        return null;
//    }
//
//    @Override
//    public List<Client> getAllLead() {
////        String query1 =
////        "SELECT j FROM Client j WHERE j.clientStatus = 'LEAD' " +
////                "and j.leadStatus <> 'Registered' ORDER BY j.id";
//
//        String query1 =
//                "SELECT j FROM Lead j WHERE j.clientStatus = Client ORDER BY j.id";
//
//        return (List<Client>) entityManager.createQuery(query1)
//                .getResultStream()
//                .collect(Collectors.toList());
//    }
//
//
//    @Override
//    public Client getClientById(long id) {
//        return entityManager.find(Client.class,id);
//    }
//
//    @Override
//    public void updateLead(Client client) {
//        getUpdatedLead(client);
//        flushAndClear();
//    }
//
//    @Override
//    public void updateStudent(Client client) {
//
//    }
//
//    @Override
//    public void deleteLeadById(long id) {
//        entityManager.remove(id);
//    }
//
//
//
//    // STUDENT
//    @Override
//    public void copyLeadToStudent(Student student) {
//        entityManager.persist(student);
//
//
//    }
//
//    @Override
//    public boolean studentExists(String email) {
//        String jpql = "from Student as a WHERE a.email =:email";
//        int count = entityManager.createQuery(jpql).setParameter("email",email).getResultList().size();
//
//        return count > 0;
//    }
//
//
//    @Override
//    public boolean leadExists(String email) {
//        String jpql = "from Lead as a WHERE a.email =:email";
//        int count = entityManager.createQuery(jpql).setParameter("email",email).getResultList().size();
//
//        return count > 0;
//    }
//
//    /////
//        @Override
//    public List<Student> getAllStudent() {
//            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//            CriteriaQuery<Student> cq = cb.createQuery(Student.class);
//            Root<Student> student = cq.from(Student.class);
//            cq.select(student).where(cb.equal(student.get("clientStatus"), "Student"));
//            TypedQuery<Student> q = entityManager.createQuery(cq);
//            List<Student> allStudents = q.getResultList();
//            return allStudents;
//    }
//
//    @Override
//    public void updateStudent(Student student) {
//
//        getUpdatedStudent(student);
//        flushAndClear();
//
//    }
//
//    @Override
//    public void deleteStudentById(long id) {
//
//        entityManager.remove(id);
//    }
//
//
//
//    private Student getUpdatedStudent(Student student) {
//
//        Student student1 = getStudentById(student.getId());
//
//        student1 = (Student) getUpdatedLead(student);
//
//        student1.setPayments(student.getPayments());
//        student1.setBalance(student.getBalance());
//        student1.setTotalFee(student.getTotalFee());
//        return student1;
//    }
//
//
//    private void flushAndClear() {
//        entityManager.flush();
//        entityManager.clear();
//    }
//
//
//    public List<Client> findLeadCourseJava() {
//        String jpql = "SELECT DISTINCT j FROM Lead j JOIN j.course c WHERE c.id =:course_id ORDER BY j.id";
//
//        return (List<Client>) entityManager.createQuery(jpql)
//                .setParameter("course_id",1)
//                .getResultStream()
//                .collect(Collectors.toList());
//    }



    //    @Override
//    public List<Client> getAllLead() {
//        String query1 =
//        "SELECT j FROM Client j WHERE j.clientStatus = 'Registered' " +
//                "OR j.clientStatus = 'Interested' ORDER BY j.id";
//
//        return (List<Client>) entityManager.createQuery(query1)
//                .getResultStream()
//                .collect(Collectors.toList());
//    }


//    @Override
//    public List<Student> getAllStudent() {
//        String jpql = "SELECT j FROM Student j ORDER BY j.id";
//        return (List<Student>) entityManager.createQuery(jpql)
//                .getResultStream()
//                .collect(Collectors.toList());
//    }




