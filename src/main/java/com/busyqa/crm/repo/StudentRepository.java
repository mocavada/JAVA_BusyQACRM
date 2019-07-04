package com.busyqa.crm.repo;


import com.busyqa.crm.model.clients.Student;

import javax.transaction.Transactional;

@Transactional
public interface StudentRepository extends UserBaseRepository<Student> {

}
