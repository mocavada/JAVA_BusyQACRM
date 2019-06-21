//package com.busyqa.crm.service;
//
//import com.busyqa.crm.model.clients.Client;
//import com.busyqa.crm.model.clients.DTOClientRequest;
//import com.busyqa.crm.model.clients.DTOClientResponse;
//import com.busyqa.crm.repo.IClientJpaRepository;
//import com.busyqa.crm.repo.IClientsRepository;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//
//@Transactional
//@Service
//public class ClientsService {
//
//    @Autowired
//    private IClientsRepository clientRepository;
//
//    @Autowired
//    private IClientJpaRepository clientJpaRepository;
//
//
//    public synchronized boolean addClient(Client client) {
//
//
//        if( clientRepository.clientExist(client.getEmail())) {
//            return false;
//        } else {
//            clientRepository.addClient(client);
//            return true;
//        }
//    }
//
//    public List<Client> getAllClient() {
//        return clientRepository.getAllClient();
//    }
//
//    public Client getClientById(int id) { return clientRepository.getClientById(id); }
//
//    public Client getClientByEmail(String email) { return clientRepository.getClientByEmail(email); }
//
//    public List<Client> getAllLead() {
//        return clientRepository.getAllLead();
//    }
//
//    public List<Client> getAllStudent() {
//        return clientRepository.getAllStudent();
//    }
//
////    public void saveLeadToStudent(Client client) {
////        clientRepository.saveLeadToStudent(client);
////    }
////
////    public void updateStudent(Client client) {
////        clientRepository.updateStudent(client);
////    }
//
//    public void deleteClientById(long id) {
//        clientRepository.deleteClientById(id);
//    }
//
//
//    public ResponseEntity<DTOClientResponse> updateLeadLead(String email, DTOClientRequest leadRequest) {
//
//        return clientJpaRepository.findByEmail(email).map(lead -> {
//
//            // PERSONAL INFO
//            if (leadRequest.getRegistrationFeePaid() && leadRequest.getPlanAgreement()) {
//                lead.setClientStatus("Student");
//            } else {
//                lead.setClientStatus("Lead");
//            }
//
//            lead.setFirstName(leadRequest.getFirstName());
//            lead.setLastName(leadRequest.getLastName());
//            lead.setEmail(leadRequest.getEmail());
//            lead.setPhone(leadRequest.getPhone());
//            lead.setEmergencyPhone(leadRequest.getEmergencyPhone());
//            lead.setComments(leadRequest.getComments());
//            // ACADEMICS
//            lead.setCourse(leadRequest.getCourse());
//
//            // BOOLEAN STATUS
//            lead.setRegistrationFeePaid(leadRequest.getRegistrationFeePaid());
//            lead.setPlanAgreement(leadRequest.getPlanAgreement());
//            lead.setCurrentlyEmployed(leadRequest.getCurrentlyEmployed());
//            lead.setCurrentlyITEmployed(leadRequest.getCurrentlyITEmployed());
//            // STATUS
//            lead.setLeadStatus(leadRequest.getLeadStatus());
//            lead.setPaymentPlan(leadRequest.getPaymentPlan());
//            lead.setLeadSource(leadRequest.getLeadSource());
//            // NOT USED
//            lead.setDesiredJob(leadRequest.getDesiredJob());
//            lead.setPaymentPlanStatus(leadRequest.getPaymentPlanStatus());
//            // ADDRESS
//            lead.setMailingStreet(leadRequest.getMailingStreet());
//            lead.setMailingCity(leadRequest.getMailingCity());
//            lead.setMailingZip(leadRequest.getMailingZip());
//            lead.setMailingState(leadRequest.getMailingState());
//            lead.setMailingCountry(leadRequest.getMailingCountry());
//
//
//            this.clientJpaRepository.save(lead);
//            DTOClientResponse leadResponse = new DTOClientResponse();
//
//            BeanUtils.copyProperties(leadRequest,leadResponse);
//
//            return ResponseEntity.ok().body(leadResponse);
//        }).orElse(ResponseEntity.notFound().build());
//    }
//
//}
//
//
//
//
////public synchronized boolean copyLeadToStudent(Client client)  {
////    Client newlead = getLeadById(client.getId());
////
////    Student student = new Student(
////            newlead.getFirstName(),
////            newlead.getLastName(),
////            newlead.getEmail(),
////            newlead.getPhone(),
////            newlead.getEmergencyPhone(),
////            "Student",
////            newlead.getRegistrationFee(),
////            newlead.getCourse(),
////            newlead.getCreatedTime(),
////            newlead.getModifiedTime(),
////            newlead.getLastActivityTime(),
////            "Registered",
////            newlead.getLeadSource(),
////            newlead.getComments(),
////            newlead.getCurrentlyEmployed(),
////            newlead.getCurrentlyITEmployed(),
////            newlead.getDesiredJob(),
////            newlead.getMailingCity(),
////            newlead.getMailingCountry(),
////            newlead.getMailingState(),
////            newlead.getMailingStreet(),
////            newlead.getMailingZip(),
////            newlead.getPaymentPlan(),
////            newlead.getPlanAgreement(),
////            newlead.getPaymentPlanStatus(),
////            newlead.getRegistrationFeePaid());
////
////    if (clientRepository.studentExists(student.getEmail())) {
////        return false;
////    } else {
////        clientRepository.copyLeadToStudent(student);
////
////        return true;
////    }
////}
//
