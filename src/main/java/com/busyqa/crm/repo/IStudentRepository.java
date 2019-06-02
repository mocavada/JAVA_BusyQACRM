package com.busyqa.crm.repo;

import com.busyqa.crm.model.clients.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> getAllStudent();
    void addStudent(Student student);
    Student getStudentById(long id);
    void updateStudent(Student student);
    void deleteStudentById(int id);

}
