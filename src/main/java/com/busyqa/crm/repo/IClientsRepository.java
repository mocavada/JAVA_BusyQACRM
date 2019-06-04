package com.busyqa.crm.repo;

import com.busyqa.crm.model.clients.Client;

import java.util.List;

public interface IClientsRepository {

    // CLIENT
    void addClient(Client client);
    List<Client> getAllClient();
    Client getClientById(int id);
    Client getClientByEmail(String email);

    List<Client> getAllLead();
    List<Client> getAllStudent();
    void updateLead(Client client);


    void saveLeadToStudent(Client client);
    void updateStudent(Client client);

    void deleteClientById(long id);


    boolean clientExist(String email);


}






    // NOT USE

    //    void addCourse(Long courseId, Long leadId);

//    void copyClientTObject(Student student);







