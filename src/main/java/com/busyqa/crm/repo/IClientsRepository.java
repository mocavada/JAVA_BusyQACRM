package com.busyqa.crm.repo;

import com.busyqa.crm.model.clients.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IClientsRepository {

    // CLIENT
    void addClient(Client client);
    List<Client> getAllClient();
    Client getClientById(int id);
    Client getClientByEmail(String email);

    List<Client> getAllLead();
    List<Client> getAllStudent();

    void deleteClientById(long id);
    boolean clientExist(String email);

    // FOR DELETE
    void saveLeadToStudent(Client client);
    void updateStudent(Client client);



}






    // NOT USE

    //    void addCourse(Long courseId, Long leadId);

//    void copyClientTObject(Student student);







