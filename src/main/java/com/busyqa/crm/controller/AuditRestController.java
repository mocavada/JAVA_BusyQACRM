package com.busyqa.crm.controller;

import com.busyqa.crm.model.clients.DTOClientResponse;
import com.busyqa.crm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/audit")
public class AuditRestController {
//
    @Autowired
    private StudentService studentService;
//
//
//
//    ///////////////////
//    // STUDENT SERVICE CONTROLLERS
//    ///////////////////
@GetMapping("/studentlist")
public List<DTOClientResponse> getLeadList() {

    return this.studentService.getAllStudents();
}


//    @PutMapping("updatestudent")
//    public ResponseEntity<Client> updateStudent(@RequestBody Client client) {
//        clientsService.updateStudent(client);
//        return new ResponseEntity<Client>(client, HttpStatus.OK);
//    }




}
