package com.busyqa.crm.repo;


import com.busyqa.crm.model.clients.Student;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface IStudentRepository extends IUserBaseRepository<Student> {
    Optional<Student> findByEmail(String email);
}
