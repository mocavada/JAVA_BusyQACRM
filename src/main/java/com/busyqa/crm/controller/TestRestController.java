//package com.busyqa.crm.controller;
//
//import com.busyqa.crm.model.clients.Client;
//import com.busyqa.crm.model.clients.ClientBuilder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/test/")
//public class TestRestController {
//
//    @GetMapping("leads")
//    public List<Client> getLeads() {
//
//        List<Client> leads = new ArrayList<>();
//        leads.add(new ClientBuilder().setFirstName("Marc").setEmail("marc@mail.com").setRegistrationFee(501).buildLead());
//        return leads;
//    }
//
//}
