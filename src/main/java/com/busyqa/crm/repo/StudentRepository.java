package com.busyqa.crm.repo;


import com.busyqa.crm.model.clients.Student;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface StudentRepository extends UserBaseRepository<Student> {

    @Query("SELECT u FROM Student u LEFT JOIN u.payments a WHERE u.id = a.student")
    List<Student> findAllPaymentMade();
}
