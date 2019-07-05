package com.busyqa.crm.repo;

import com.busyqa.crm.model.auth.Employee;

import javax.transaction.Transactional;

@Transactional
public interface EmployeeRepository extends UserBaseRepository<Employee> {
}
