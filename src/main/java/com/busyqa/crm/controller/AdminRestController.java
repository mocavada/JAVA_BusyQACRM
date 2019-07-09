package com.busyqa.crm.controller;


import com.busyqa.crm.model.auth.DTOUserGroup;
import com.busyqa.crm.model.auth.UserGroup;
import com.busyqa.crm.model.clients.DTOClient;
import com.busyqa.crm.model.clients.Lead;
import com.busyqa.crm.service.AcademicsService;
import com.busyqa.crm.service.LeadService;
import com.busyqa.crm.service.MailService;
import com.busyqa.crm.service.UserGroupService;
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
    @GetMapping("/usersList/{type}/{status}")
    public List<DTOClient> getAllLeadsByDtypeAndClientStatus(@PathVariable("type") String type , @PathVariable("status") String status) {
        return this.leadService.getAllLeadsByDtypeAndClientStatus(type,status);
    }


    @GetMapping("/employee/{email}")
    public DTOClient getEmployeeByEmail(@PathVariable("email") String email)  {
        return this.leadService.getLeadByEmail(email);
    }


    @PutMapping("/changeLeadToEmployee/{email}")
    public Lead employeeToStudent(@PathVariable("email") String email) {

        return leadService.changeLeadToEmployee(email);
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
