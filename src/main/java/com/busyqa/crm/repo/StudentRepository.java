package com.busyqa.crm.repo;


import com.busyqa.crm.model.clients.Student;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface StudentRepository extends UserBaseRepository<Student> {
    Optional<Student> findByEmail(String email);
    Optional<Student> findById(Long id);

}
