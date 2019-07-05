package com.busyqa.crm.controller;


import com.busyqa.crm.model.auth.DTOEmployee;
import com.busyqa.crm.model.auth.DTOUserGroup;
import com.busyqa.crm.model.auth.Employee;
import com.busyqa.crm.model.auth.UserGroup;
import com.busyqa.crm.model.clients.DTOClient;
import com.busyqa.crm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admin")
public class AdminRestController {

    @Autowired
    private AcademicsService academicsService;

    @Autowired
    private MailService mailService;

    @Autowired
    private LeadService leadService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserGroupService userGroupService;


    @GetMapping("/usersList")
    public List<DTOClient> getUsersList() {

        return this.leadService.getAllUsers();
    }


    // USER GROUP SERVICE
    @PostMapping("/addUserGroup")
    @ResponseStatus(HttpStatus.OK)
    public UserGroup addUserGroup(@RequestBody DTOUserGroup dtoUserGroup) {
        return this.userGroupService.createUserGroup(dtoUserGroup);
    }

    @GetMapping("/userGroupsList")
    public List<DTOUserGroup> getUserGroupsList() {
        return this.userGroupService.getAllUsersGroups();
    }


    // EMPLOYEE SERVICE
    @GetMapping("/usersList/{type}")
    public List<DTOEmployee> getEmployeeListByDType(@PathVariable("type") String type) {
        return this.employeeService.getAllEmployeesByDtype(type);
    }


    @GetMapping("/employee/{email}")
    public DTOEmployee getEmployeeByEmail(@PathVariable("email") String email) {
        return this.employeeService.getEmployeeByEmail(email);
    }



    @DeleteMapping("/changeLeadToEmployee/{email}")
    public Employee employeeToStudent(@PathVariable("email") String email) {

        return employeeService.changeLeadToEmployee(email);
    }








//    @Autowired
//    private ClientsService clientsService;
//
//    ///////////////////
//    // CLIENT SERVICE CONTROLLERS
//    ///////////////////
//    @GetMapping("clientlist")
//    public ResponseEntity<List<Client>> getAllClient() {
//        List<Client> list = clientsService.getAllClient();
//        return new ResponseEntity<List<Client>>(list, HttpStatus.OK);
//    }
//
//
//    @DeleteMapping("deleteclient/{id}")
//    public ResponseEntity<Void> deleteClientById(@PathVariable("id") long id ) {
//        clientsService.deleteClientById(id);
//        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//    }

    ///////////////////
    // USER SERVICE CONTROLLERS
    ///////////////////



}
