package com.busyqa.crm.controller;


import com.busyqa.crm.model.clients.DTOClientResponse;
import com.busyqa.crm.service.AcademicsService;
import com.busyqa.crm.service.LeadService;
import com.busyqa.crm.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/admin/")
public class AdminRestController {

    @Autowired
    private AcademicsService academicsService;

    @Autowired
    private MailService mailService;

    @Autowired
    private LeadService leadService;


    @GetMapping("/userslist")
    public List<DTOClientResponse> getUsersList() {

        return this.leadService.getAllUsers();
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
