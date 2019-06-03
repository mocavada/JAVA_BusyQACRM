package com.busyqa.crm.controller;

import com.busyqa.crm.model.clients.Client;
import com.busyqa.crm.service.AcademicsService;
import com.busyqa.crm.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admin/")
public class AdminRestController {

    @Autowired
    private ClientsService clientsService;

    @Autowired
    private AcademicsService academicsService;

    @GetMapping("clientlist")
    public ResponseEntity<List<Client>> getAllClient() {
        List<Client> list = clientsService.getAllClient();
        return new ResponseEntity<List<Client>>(list, HttpStatus.OK);
    }

    @GetMapping("lead/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id) {
        Client client = clientsService.getClientById(id);
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    @DeleteMapping("deleteclient/{id}")
    public ResponseEntity<Void> deleteClientById(@PathVariable("id") long id ) {
        clientsService.deleteClientById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }



}
