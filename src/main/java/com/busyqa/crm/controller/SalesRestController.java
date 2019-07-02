package com.busyqa.crm.controller;

import com.busyqa.crm.model.Mail;
import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.clients.DTOClientRequest;
import com.busyqa.crm.model.clients.DTOClientResponse;
import com.busyqa.crm.model.clients.Student;
import com.busyqa.crm.service.AcademicsService;
import com.busyqa.crm.service.LeadService;
import com.busyqa.crm.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/sales")
public class SalesRestController {

    @Autowired
    private AcademicsService academicsService;

    @Autowired
    private MailService mailService;

    @Autowired
    private LeadService leadService;

    ///////////////////
    // LEAD SERVICE
    ///////////////////
    @GetMapping("/leadslist")
    public List<DTOClientResponse> getLeadList() {
        return this.leadService.getAllLeadsMO();
    }


    @GetMapping("/lead/{email}")
    public DTOClientResponse getLeadByEmail(@PathVariable("email") String email) {
        return this.leadService.getLeadByEmailMO(email);
    }


    @PutMapping("/updatelead/{email}")
    public ResponseEntity<DTOClientResponse> updateLead(@PathVariable("email") String email, @RequestBody DTOClientRequest leadRequest) {
        return leadService.updateLeadMO(email,leadRequest);
    }

    @DeleteMapping("/changeLeadToStudent/{email}")
    public Student leadToStudent(@PathVariable("email") String email) {

        return leadService.changeLeadToStudent(email);
    }



    ///////////////////
    // ACADEMICS --- COURSE SERVICE
    ///////////////////
    @PostMapping("/addcourse")
    public ResponseEntity<Void> addCourse(@RequestBody Course course, UriComponentsBuilder builder) {

        boolean flag = academicsService.addCourse(course);

        if (!flag) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/addcourse").buildAndExpand(course.getName()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    @GetMapping("/courselist")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> list = academicsService.getAllCourse();
        return new ResponseEntity<List<Course>>(list, HttpStatus.OK);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") int id) {
        Course course = academicsService.getCourseById(id);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }


    ///////////////////
    // EMAIL SERVICE CONTROLLERS
    ///////////////////

    @RequestMapping("/sendEmail/{email}")
    public String send(@PathVariable("email") String email) {
        try {
            mailService.sendEmail(email);
        } catch(MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your email has been sent.";
    }


    @RequestMapping("/sendEmailWithAttachment/{email}")
    public String sendWithAttachment(@PathVariable("email") String email) throws MessagingException {

        /*
         * Here we will call sendEmailWithAttachment() for Sending mail to the sender
         * that contains a attachment.
         */
        try {
            mailService.sendEmailWithAttachment(email);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your email with attachment has been sent.";
    }


    // SEND WELCOME PACKAGE EMAIL
    @PostMapping("/sendEmailWithTemplate/")
    public ResponseEntity<?> sendMailWithTemplate(@Valid @RequestBody Mail mail, Errors errors){
        if(errors.hasErrors()){
            return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return mailService.sendPreparedMail(mail);
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


//    @PostMapping("/addlead")
//    public ResponseEntity<Void> addLead(@RequestBody Client client, UriComponentsBuilder builder) {
//
//        boolean flag = clientsService.addClient(client);
//
//        if (!flag) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        HttpHeaders headers = new HttpHeaders();
//
//        headers.setLocation(builder.path("/addlead/{id}").buildAndExpand(client.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }


//    @PutMapping("/updatecourse")
//    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
//        academicsService.updateCourse(course);
//        return new ResponseEntity<Course>(course, HttpStatus.OK);
//    }



//    @DeleteMapping("/deletecourse/{id}")
//    public ResponseEntity<Void> deleteCourseById(@PathVariable("id") int id ) {
//        academicsService.deleteCourseById(id);
//        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//    }

///////////////////
// CLASS SERVICE CONTROLLERS
///////////////////
//    @PutMapping("/course/{classId}/{courseId}")
//    public ResponseEntity<Void> addClassToCourse(@PathVariable("classId") Integer classId, @PathVariable("courseId") Integer courseId, UriComponentsBuilder builder) {
//        academicsService.addClass(classId, courseId);
//        return new ResponseEntity<Void>(HttpStatus.OK);
//    }
