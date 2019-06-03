package com.busyqa.crm.controller;

import com.busyqa.crm.model.clients.Lead;
import com.busyqa.crm.model.clients.Student;
import com.busyqa.crm.service.AcademicsService;
import com.busyqa.crm.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/audit/")
public class AuditRestController {

    @Autowired
    private ClientsService clientsService;

    @Autowired
    private AcademicsService academicsService;


    @GetMapping("studentlist")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> list = clientsService.getAllStudent();
        return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
    }






}
