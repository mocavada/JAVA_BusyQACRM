package com.busyqa.crm.repo;

import com.busyqa.crm.model.clients.Lead;
import com.busyqa.crm.model.clients.Student;

import java.util.List;

public interface IClientRepository {

    // LEAD
    void addLead(Lead lead);

//    void addCourse(Long courseId, Long leadId);

    List<Lead> getAllLead();

    Lead getLeadById(long id);

    void updateLead(Lead lead);

    void deleteLeadById(long id);

    // STUDENT

    void copyLeadToStudent(Student student);

    boolean leadExists(String email);

    boolean studentExists(String email);

    List<Student> getAllStudent();

    Student getStudentById(long id);

    void updateStudent(Student student);

    void deleteStudentById(long id);







}
