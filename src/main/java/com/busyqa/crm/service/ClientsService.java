package com.busyqa.crm.service;

import com.busyqa.crm.model.clients.Client;
import com.busyqa.crm.repo.IClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ClientsService {

    @Autowired
    private IClientsRepository clientRepository;

    public synchronized boolean addClient(Client client) {
        if( clientRepository.clientExist(client.getEmail())) {
            return false;
        } else {
            clientRepository.addClient(client);
            return true;
        }
    }

    public List<Client> getAllClient() {
        return clientRepository.getAllClient();
    }

    public Client getClientById(int id) {

        return clientRepository.getClientById(id);
    }

    public Client getClientByEmail(String email) {

        return clientRepository.getClientByEmail(email);
    }

    public List<Client> getAllLead() {
        return clientRepository.getAllLead();
    }

    public List<Client> getAllStudent() {
        return clientRepository.getAllStudent();
    }

    public void updateLead(Client client) {
        clientRepository.updateLead(client);
    }


    public void saveLeadToStudent(Client client) {
        clientRepository.saveLeadToStudent(client);
    }

    public void updateStudent(Client client) {
        clientRepository.updateStudent(client);
    }

    public void deleteClientById(long id) {
        clientRepository.deleteClientById(id);
    }

}


//public synchronized boolean copyLeadToStudent(Client client)  {
//    Client newlead = getLeadById(client.getId());
//
//    Student student = new Student(
//            newlead.getFirstName(),
//            newlead.getLastName(),
//            newlead.getEmail(),
//            newlead.getPhone(),
//            newlead.getEmergencyPhone(),
//            "Student",
//            newlead.getRegistrationFee(),
//            newlead.getCourse(),
//            newlead.getCreatedTime(),
//            newlead.getModifiedTime(),
//            newlead.getLastActivityTime(),
//            "Registered",
//            newlead.getLeadSource(),
//            newlead.getComments(),
//            newlead.getCurrentlyEmployed(),
//            newlead.getCurrentlyITEmployed(),
//            newlead.getDesiredJob(),
//            newlead.getMailingCity(),
//            newlead.getMailingCountry(),
//            newlead.getMailingState(),
//            newlead.getMailingStreet(),
//            newlead.getMailingZip(),
//            newlead.getPaymentPlan(),
//            newlead.getPlanAgreement(),
//            newlead.getPaymentPlanStatus(),
//            newlead.getRegistrationFeePaid());
//
//    if (clientRepository.studentExists(student.getEmail())) {
//        return false;
//    } else {
//        clientRepository.copyLeadToStudent(student);
//
//        return true;
//    }
//}

