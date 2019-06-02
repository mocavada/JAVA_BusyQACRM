package com.busyqa.crm.controller;

import com.busyqa.crm.model.clients.Lead;
import com.busyqa.crm.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/sales/")
public class SalesRestController {

    @Autowired
    private ClientsService clientsService;

    @GetMapping("leadslist")
    public ResponseEntity<List<Lead>> getAllLeads() {
        List<Lead> list = clientsService.getAllLeads();
        return new ResponseEntity<List<Lead>>(list, HttpStatus.OK);
    }


    @PostMapping("addlead")
    public ResponseEntity<Void> addJobPost(@RequestBody Lead lead, UriComponentsBuilder builder) {
        clientsService.addLead(lead);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("addlead").buildAndExpand(lead.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping("lead/{id}")
    public ResponseEntity<Lead> getLeadById(@PathVariable("id") Long id) {
        Lead jobPost = clientsService.getLeadById(id);
        return new ResponseEntity<Lead>(jobPost, HttpStatus.OK);
    }

    @PutMapping("updatelead")
    public ResponseEntity<Lead> updateJobPost(@RequestBody Lead lead) {
        clientsService.updateLead(lead);
        return new ResponseEntity<Lead>(lead, HttpStatus.OK);
    }


    @DeleteMapping("deletelead/{id}")
    public ResponseEntity<Void> deleteLeadById(@PathVariable("id") int id ) {
        clientsService.deleteLeadById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }




}
