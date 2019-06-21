package com.busyqa.crm.controller;

import com.busyqa.crm.service.AcademicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/audit/")
public class AuditRestController {
//
//    @Autowired
//    private ClientsService clientsService;
//
//
//
//    ///////////////////
//    // STUDENT SERVICE CONTROLLERS
//    ///////////////////
//    @GetMapping("studentslist")
//    public ResponseEntity<List<Client>> getAllStudent() {
//        List<Client> list = clientsService.getAllStudent();
//        return new ResponseEntity<List<Client>>(list, HttpStatus.OK);
//    }

//    @PutMapping("updatestudent")
//    public ResponseEntity<Client> updateStudent(@RequestBody Client client) {
//        clientsService.updateStudent(client);
//        return new ResponseEntity<Client>(client, HttpStatus.OK);
//    }




}
