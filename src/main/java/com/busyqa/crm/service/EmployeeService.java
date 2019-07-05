package com.busyqa.crm.service;

import com.busyqa.crm.model.auth.DTOEmployee;
import com.busyqa.crm.model.auth.Employee;
import com.busyqa.crm.model.clients.Lead;
import com.busyqa.crm.repo.EmployeeRepository;
import com.busyqa.crm.repo.LeadRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LeadRepository leadRepository;

    /**
     * @param type
     * @return
     */
    public List<DTOEmployee> getAllEmployeesByDtype(String type) {

        List<Employee> employees = employeeRepository.findAllByDtype(type);

        if (employees.isEmpty()) throw new RuntimeException("Empty Employee list!");

        List<DTOEmployee> employeeResponses = new ArrayList<>();

        System.out.println(employees.size());

        for (Employee l: employees) {
            employeeResponses.add(getEmployee(l));
        }
        return employeeResponses;
    }

    /**
     * @param email
     * @return
     */
    public DTOEmployee getEmployeeByEmail(String email) {

        Employee l = employeeRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Error: Email not found!"));
        return getEmployee(l);
    }


    /**
     * @param email
     * @return
     */
    public Employee changeLeadToEmployee(String email) {

        Lead lead = leadRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Fail! -> Lead Not Found"));

//        Course course = academicsRepository.findByCourseName(lead.getCourse()
//                .getName()).orElseThrow(() -> new RuntimeException("Fail! -> No Course Found"));

//        List<UserGroup> usergroups = userGroupRepository.findAll();
//
//        for(UserGroup ug: usergroups) {
//            lead.removeUserGroup(ug);
//            userGroupRepository.save(ug);
//        }
//
//        UserGroup userGroup = userGroupRepository
//                .findByRoleAndGroups("ROLE_USER", "GROUP_CLIENT")
//                .orElseThrow(() -> new RuntimeException("Fail! -> UserGroup Not Found"));
//
//        Set<UserGroup> newUserGroupSet = new HashSet<>();
//
//        newUserGroupSet.add(userGroup);


        Employee employee = new Employee();

        BeanUtils.copyProperties(lead,employee);

//        student.setCourse(course);


//        student.setRegistrationFeePaid(true);

        leadRepository.deleteByEmail(email);

        Employee saveEmployee = employeeRepository.save(employee);
        return saveEmployee;

    }

    /**
     * @param l
     * @return
     */
    public DTOEmployee getEmployee(Employee l) {

        return new DTOEmployee(
                l.getCreatedTime(),
                l.getModifiedTime(),
                l.getId(),
                l.getUsername(),
                l.getEmail(),

                l.getFirstName(),
                l.getLastName(),
                l.getPhoneNumber(),
                l.getEmergencyPhone(),

                l.getJobTitle(),
                l.getJobDescription(),
                l.getJobStatus(),
                l.getAnnualSalary(),

                l.getUsergroups()

        );

    }




}
