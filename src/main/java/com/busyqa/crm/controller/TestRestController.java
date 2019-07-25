//package com.busyqa.crm.controller;
//
//import com.busyqa.crm.model.clients.Client;
//import com.busyqa.crm.model.clients.ClientBuilder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.utils.ArrayList;
//import java.utils.List;
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


// OLD AUDIT CONTROLLER

//    @PutMapping("updatestudent")
//    public ResponseEntity<Client> updateStudent(@RequestBody Client client) {
//        clientsService.updateStudent(client);
//        return new ResponseEntity<Client>(client, HttpStatus.OK);
//    }




//@GetMapping("/studentlist")
//public List<DTOClient> getLeadList() {
//        return this.studentService.getAllStudents();
//        }





// OLD SALES CONTROLLER
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





// OLD SERVICE QUERY SAMPLE

//    @Override
//    public List<Client> getAllLead() {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Client> cq = cb.createQuery(Client.class);
//        Root<Client> client = cq.from(Client.class);
//
//        cq.select(client).where(cb.equal(client.get("clientStatus"), "Lead"));
//        TypedQuery<Client> q = entityManager.createQuery(cq);
//        List<Client> allLeads = q.getResultList();
//        return allLeads;
//    }
//


//    @Override
//    public List<Client> getAllClient() {
//        String jpql = "SELECT c FROM Client c ORDER BY c.id";
//        return (List<Client>) entityManager.createQuery(jpql)
//                .getResultStream()
//                .collect(Collectors.toList());
//    }



//    @Override
//    public boolean clientExist(String email) {
//        String jpql = "from Client as a WHERE a.email =: email";
//        int count = entityManager.createQuery(jpql)
//                .setParameter("email",email)
//                .getResultList().size();
//        return count > 0;
//    }