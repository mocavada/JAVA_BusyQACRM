package com.busyqa.crm.controller;

import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.clients.Client;
import com.busyqa.crm.service.AcademicsService;
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

    @Autowired
    private AcademicsService academicsService;

    ///////////////////
    // LEAD SERVICE CONTROLLERS
    ///////////////////
    @PostMapping("addlead")
    public ResponseEntity<Void> addLead(@RequestBody Client client, UriComponentsBuilder builder) {

        boolean flag = clientsService.addClient(client);

        if (!flag) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("addlead/{id}").buildAndExpand(client.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping("leadslist")
    public ResponseEntity<List<Client>> getAllLeads() {
        List<Client> list = clientsService.getAllLead();
        return new ResponseEntity<List<Client>>(list, HttpStatus.OK);
    }


    @PutMapping("updatelead")
    public ResponseEntity<Client> updateLead(@RequestBody Client client) {
        clientsService.updateLead(client);
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }


    ///////////////////
    // COURSE SERVICE CONTROLLERS
    ///////////////////
    @GetMapping("courselist")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> list = academicsService.getAllCourse();
        return new ResponseEntity<List<Course>>(list, HttpStatus.OK);
    }

    @PostMapping("addcourse")
    public ResponseEntity<Void> addCourse(@RequestBody Course course, UriComponentsBuilder builder) {
        academicsService.addCourse(course);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("addcourse/{id}").buildAndExpand(course.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping("course/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") int id) {
        Course course = academicsService.getCourseById(id);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

    @PutMapping("updatecourse")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        academicsService.updateCourse(course);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

    @DeleteMapping("deletecourse/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable("id") int id ) {
        academicsService.deleteCourseById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    ///////////////////
    // CLASS SERVICE CONTROLLERS
    ///////////////////
    @PutMapping("course/{classId}/{courseId}")
    public ResponseEntity<Void> addClassToCourse(@PathVariable("classId") Integer classId, @PathVariable("courseId") Integer courseId, UriComponentsBuilder builder) {
        academicsService.addClass(classId, courseId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}






//    @PutMapping("updatelead")
//    public ResponseEntity<Client> updateJobPost(@RequestBody Client lead) {
//        clientsService.updateLead(lead);
//        return new ResponseEntity<Client>(lead, HttpStatus.OK);
//    }


//    @PostMapping("copyleadtostudent")
//    public ResponseEntity<Void> copyLeadToStudent(@RequestBody Client client, UriComponentsBuilder builder) {
//
//        boolean flag = clientsService.copyLeadToStudent(client);
//
//        if (!flag) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("copyleadtostudent/{id}").buildAndExpand(client.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }