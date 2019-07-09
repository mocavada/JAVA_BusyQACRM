package com.busyqa.crm.service;


import com.busyqa.crm.model.clients.DTOClient;
import com.busyqa.crm.model.clients.Lead;
import com.busyqa.crm.model.clients.Student;
import com.busyqa.crm.repo.LeadRepository;
import com.busyqa.crm.repo.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeadService {


    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private StudentRepository studentRepository;


    /**
     * @return
     */
    public List<DTOClient> getAllUsers() {

        List<Lead> leads = leadRepository.findAll();

        if (leads.isEmpty()) throw new RuntimeException("Empty Lead list!");

        List<DTOClient> leadResponses = new ArrayList<>();

        System.out.println(leads.size());

        for (Lead l: leads) {
            leadResponses.add(getLead(l));
        }

        return leadResponses;
    }

    public List<DTOClient> getAllLeadsByDtype(String type) {

        List<Lead> leads = leadRepository.findAllByDtype(type);

        if (leads.isEmpty()) throw new RuntimeException("Empty Lead list!");

        List<DTOClient> leadResponses = new ArrayList<>();

        System.out.println(leads.size());

        for (Lead l: leads) {
            leadResponses.add(getLead(l));
        }

        return leadResponses;
    }

    public List<DTOClient> getAllLeadsByDtypeAndClientStatus(String type, String group) {

        List<Lead> leads = leadRepository.findAllByDtypeAndClientStatus(type,group);

        if (leads.isEmpty()) throw new RuntimeException("Empty Lead list!");

        List<DTOClient> leadResponses = new ArrayList<>();

        System.out.println(leads.size());

        for (Lead l: leads) {
            leadResponses.add(getLead(l));
        }

        return leadResponses;
    }

    /**
     * @param email
     * @return
     */
    public DTOClient getLeadByEmail(String email) {

        Lead l = leadRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Error: Email not found!"));
        return getLead(l);
    }

    /**
     * @param email
     * @param leadRequest
     * @return
     */
    public ResponseEntity<DTOClient> updateLead(String email, DTOClient leadRequest) {

        return leadRepository.findByEmail(email).map(l -> {

            double totalFee = getTotalFee(l);
            boolean discountGiven = isDiscountGiven(l);
            boolean registrationPaid = isRegistrationPaid(l);

            l.setEmail(leadRequest.getEmail());
            l.setFirstName(leadRequest.getFirstName());
            l.setLastName(leadRequest.getLastName());
            l.setPhoneNumber(leadRequest.getPhoneNumber());
            l.setEmergencyPhone(leadRequest.getEmergencyPhone());

            l.setClientStatus(leadRequest.getClientStatus());
            l.setLeadSource(leadRequest.getLeadSource());
            l.setComments(leadRequest.getComments());
            l.setCurrentlyEmployed(leadRequest.getCurrentlyEmployed());
            l.setCurrentlyITEmployed(leadRequest.getCurrentlyITEmployed());
            l.setDesiredJob(leadRequest.getDesiredJob());

            l.setMailingStreet(leadRequest.getMailingStreet());
            l.setMailingCity(leadRequest.getMailingCity());
            l.setMailingState(leadRequest.getMailingState());
            l.setMailingZip(leadRequest.getMailingZip());
            l.setMailingCountry(leadRequest.getMailingCountry());

            l.setRegistrationFeePaid(registrationPaid);
            l.setPlanAgreementSigned(leadRequest.getPlanAgreementSigned());
            l.setDiscountGiven(discountGiven);

            l.setRegistrationFee(leadRequest.getRegistrationFee());
            l.setDiscount(leadRequest.getDiscount());
            l.setPaymentPlan(leadRequest.getPaymentPlan());

            l.setCourse(leadRequest.getCourse());

            l.setTotalCourseFee(totalFee);

            l.setCourseSchedule(leadRequest.getCourseSchedule());
            l.setTrainer(leadRequest.getTrainer());
            l.setTrainingLocation(leadRequest.getTrainingLocation());


            this.leadRepository.save(l);
            DTOClient leadResonse = new DTOClient();
            BeanUtils.copyProperties(leadRequest, leadResonse);

            return ResponseEntity.ok().body(leadResonse);
        }).orElse(ResponseEntity.notFound().build());

    }

    /**
     * @param email
     * @return
     */
    public Student changeLeadToStudent(String email) {

        Lead lead = leadRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Fail! -> Lead Not Found"));

//        Course course = academicsRepository.findByCourseName(lead.getCourse()
//                .getName()).orElseThrow(() -> new RuntimeException("Fail! -> No Course Found"));

//        List<UserGroup> usergroups = userGroupRepository.findAll();
//
//        for(UserGroup ug: usergroups) {
//            lead.removeUserGroup(ug);
//            userGroupRepository.save(ug);
//        }
//
//        UserGroup userGroup = userGroupRepository
//                .findByRoleAndGroups("ROLE_USER", "GROUP_CLIENT")
//                .orElseThrow(() -> new RuntimeException("Fail! -> UserGroup Not Found"));
//
//        Set<UserGroup> newUserGroupSet = new HashSet<>();
//
//        newUserGroupSet.add(userGroup);


        Student student = new Student();

        BeanUtils.copyProperties(lead,student);

//        student.setCourse(course);


//        student.setRegistrationFeePaid(true);

        leadRepository.deleteByEmail(email);

        Student saveStudent = studentRepository.save(student);
        return saveStudent;

    }

    /**
     * @param l
     * @return
     */
    public DTOClient getLead(Lead l) {


        return new DTOClient(
                l.getCreatedTime(),
                l.getModifiedTime(),
                l.getEmail(),
                l.getFirstName(),
                l.getLastName(),
                l.getPhoneNumber(),
                l.getEmergencyPhone(),

                l.getClientStatus(),
                l.getLeadSource(),
                l.getComments(),
                l.getCurrentlyEmployed(),
                l.getCurrentlyITEmployed(),
                l.getDesiredJob(),

                l.getMailingStreet(),
                l.getMailingCity(),
                l.getMailingState(),
                l.getMailingZip(),
                l.getMailingCountry(),

                l.getRegistrationFeePaid(),
                l.getPlanAgreementSigned(),
                l.getDiscountGiven(),

                l.getRegistrationFee(),
                l.getDiscount(),
                l.getPaymentPlan(),

                l.getCourse(),

                l.getTotalCourseFee(),


                l.getCourseSchedule(),
                l.getTrainer(),
                l.getTrainingLocation()

        );

    }


    public double getTotalFee(Lead l) {

        if(l.getDiscountGiven()) {
            return l.getCourse().getFee() - l.getDiscount().getAmount();

        } else {
            return l.getCourse().getFee();
        }

    }

    public Boolean isDiscountGiven(Lead l) {

        if (l.getDiscount() != null) {
            return true;
        } else {
            return false;
        }

    }

    public Boolean isRegistrationPaid(Lead l) {

        if (l.getRegistrationFee() != null) {
            return true;
        } else {
            return false;
        }

    }







} // Last

