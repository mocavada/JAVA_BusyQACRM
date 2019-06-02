package com.busyqa.crm.repo;

import com.busyqa.crm.model.academics.Class;
import com.busyqa.crm.model.clients.Lead;
import com.busyqa.crm.model.clients.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Repository
public class StudentRepository implements IStudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudent() {
        String jpql = "SELECT j FROM Student j ORDER BY j.id";

        return (List<Student>) entityManager.createQuery(jpql)
                .getResultStream()
                .collect(Collectors.toList());
    }

    @Override
    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student getStudentById(long id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public void updateStudent(Student student) {
        Student updateStudent = getStudentById(student.getId());
        updateStudent.setTotalFee(student.getTotalFee());
        updateStudent.setBalance(student.getBalance());
        updateStudent.setPayments(student.getPayments());
        entityManager.flush();

    }

    @Override
    public void deleteStudentById(int id) {
        entityManager.remove(id);
    }
}
