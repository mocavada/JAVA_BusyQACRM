package com.busyqa.crm.controller;

import com.busyqa.crm.model.util.Mail;
import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.academics.CourseSchedule;
import com.busyqa.crm.model.academics.Trainer;
import com.busyqa.crm.model.academics.TrainingLocation;
import com.busyqa.crm.model.clients.DTOClient;
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


    // LEAD SERVICE
    ///////////////////
    @GetMapping("/usersList/{type}/{status}")
    public List<DTOClient> getAllLeadsByDtypeAndClientStatus(@PathVariable("type") String type , @PathVariable("status") String status) {
        return this.leadService.getAllLeadsByDtypeAndClientStatus(type,status);
    }


    @GetMapping("/lead/{email}")
    public DTOClient getLeadByEmail(@PathVariable("email") String email) {
        return this.leadService.getLeadByEmail(email);
    }

    @GetMapping("/leadbyuser/{username}")
    public DTOClient getLeadByUsername(@PathVariable("username") String username) {
        return this.leadService.getLeadByUsername(username);
    }


    @PutMapping("/updateLead/{email}")
    public ResponseEntity<DTOClient> updateLeadByEmail(@PathVariable("email") String email, @RequestBody DTOClient leadRequest) {
        return leadService.updateLead(email,leadRequest);
    }

    @DeleteMapping("/leadToStudent/{email}")
    public Student changeLeadToStudent(@PathVariable("email") String email) {

        return leadService.changeLeadToStudent(email);
    }

    // ACADEMICS --- COURSE SERVICE
    ///////////////////
    @PostMapping("/addCourse")
    public ResponseEntity<Void> addCourse(@RequestBody Course course, UriComponentsBuilder builder) {

        boolean flag = academicsService.addCourse(course);

        if (!flag) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/addCourse").buildAndExpand(course.getName()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    @GetMapping("/getAllCourse")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> list = academicsService.getAllCourse();
        return new ResponseEntity<List<Course>>(list, HttpStatus.OK);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") int id) {
        Course course = academicsService.getCourseById(id);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }


    // ACADEMICS --- COURSE SCHEDULE
    ///////////////////
    @PostMapping("/addCourseSchedule")
    public ResponseEntity<Void> addCourseSchedule(@RequestBody CourseSchedule courseSchedule, UriComponentsBuilder builder) {

        boolean flag = academicsService.addCourseSchedule(courseSchedule);

        if (!flag) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/addCourseSchedule").buildAndExpand(courseSchedule.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    @GetMapping("/getAllCourseSchedule")
    public ResponseEntity<List<CourseSchedule>> getAllCourseSchedule() {
        List<CourseSchedule> list = academicsService.getAllCourseSchedule();
        return new ResponseEntity<List<CourseSchedule>>(list, HttpStatus.OK);
    }


    // ACADEMICS --- TRAINER
    ///////////////////
    @PostMapping("/addTrainer")
    public ResponseEntity<Void> addTrainer(@RequestBody Trainer trainer, UriComponentsBuilder builder) {

        boolean flag = academicsService.addTrainer(trainer);

        if (!flag) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/addTrainer").buildAndExpand(trainer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    @GetMapping("/getAllTrainer")
    public ResponseEntity<List<Trainer>> getAllTrainer() {
        List<Trainer> list = academicsService.getAllTrainer();
        return new ResponseEntity<List<Trainer>>(list, HttpStatus.OK);
    }

    // ACADEMICS --- TRAINING LOCATION
    ///////////////////
    @PostMapping("/addTrainingLocation")
    public ResponseEntity<Void> addTrainingLocation(@RequestBody TrainingLocation trainingLocation, UriComponentsBuilder builder) {

        boolean flag = academicsService.addTrainingLocation(trainingLocation);

        if (!flag) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/addTrainingLocation").buildAndExpand(trainingLocation.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    @GetMapping("/getAllTrainingLocation")
    public ResponseEntity<List<TrainingLocation>> getAllTrainingLocation() {
        List<TrainingLocation> list = academicsService.getAllTrainingLocation();
        return new ResponseEntity<List<TrainingLocation>>(list, HttpStatus.OK);
    }


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


