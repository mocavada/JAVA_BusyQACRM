package com.busyqa.crm.service;


import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.auth.DTOResponseMessage;
import com.busyqa.crm.model.auth.UserGroup;
import com.busyqa.crm.model.clients.DTOLeadRequest;
import com.busyqa.crm.model.clients.DTOLeadResponse;
import com.busyqa.crm.model.clients.Lead;
import com.busyqa.crm.model.clients.Student;
import com.busyqa.crm.repo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LeadService {

    @Autowired
    private IUserGroupRepository userGroupRepository;

    @Autowired
    private ILeadRepository leadRepository;

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private IAcademicsRepository academicsRepository;

    /**
     *
     * @return
     */
    public List<DTOLeadResponse> getAllLeadsMO() {

        List<Lead> leads = leadRepository.findAll();

        if (leads.isEmpty()) throw new RuntimeException("Empty Lead list!");

        List<DTOLeadResponse> leadResponses = new ArrayList<>();

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
    public DTOLeadResponse getLeadByEmailMO(String email) {

        Lead l = leadRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Error: Email not found!"));
        return getLead(l);
    }



    /**
     * @param email
     * @param leadRequest
     * @return
     */

    public ResponseEntity<DTOLeadResponse> updateLeadMO(String email, DTOLeadRequest leadRequest) {

        return leadRepository.findByEmail(email).map(l -> {
            l.setEmail(leadRequest.getEmail());
            l.setFirstName(leadRequest.getFirstName());
            l.setLastName(leadRequest.getLastName());
            l.setPhoneNumber(leadRequest.getPhoneNumber());
            l.setEmergencyPhone(leadRequest.getEmergencyPhone());
            l.setClientStatus(leadRequest.getClientStatus());
            l.setRegistrationFee(leadRequest.getRegistrationFee());
            l.setDiscount(leadRequest.getDiscount());
            l.setLeadStatus(leadRequest.getLeadStatus());
            l.setLeadSource(leadRequest.getLeadSource());
            l.setComments(leadRequest.getComments());
            l.setCurrentlyEmployed(leadRequest.getCurrentlyEmployed());
            l.setCurrentlyITEmployed(leadRequest.getCurrentlyITEmployed());
            l.setDesiredJob(leadRequest.getDesiredJob());
            l.setPaymentPlan(leadRequest.getPaymentPlan());
            l.setPaymentPlanStatus(leadRequest.getPaymentPlanStatus());
            l.setRegistrationFeePaid(leadRequest.getRegistrationFeePaid());
            l.setPlanAgreement(leadRequest.getPlanAgreement());
            l.setMailingStreet(leadRequest.getMailingStreet());
            l.setMailingCity(leadRequest.getMailingCity());
            l.setMailingState(leadRequest.getMailingState());
            l.setMailingZip(leadRequest.getMailingZip());
            l.setMailingCountry(leadRequest.getMailingCountry());
            l.setCourse(leadRequest.getCourse());
            l.setCourseSchedule(leadRequest.getCourseSchedule());
            l.setTrainer(leadRequest.getTrainer());
            l.setTrainingLocation(leadRequest.getTrainingLocation());

            this.leadRepository.save(l);

            DTOLeadResponse leadResonse = new DTOLeadResponse();
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

        Course course = academicsRepository.findByCourseName(lead.getCourse()
                .getName()).orElseThrow(() -> new RuntimeException("Fail! -> No Course Found"));

        List<UserGroup> usergroups = userGroupRepository.findAll();

        for(UserGroup ug: usergroups) {
            lead.removeUserGroup(ug);
            userGroupRepository.save(ug);
        }

        UserGroup userGroup = userGroupRepository
                .findByRoleAndGroups("ROLE_USER", "GROUP_CLIENT")
                .orElseThrow(() -> new RuntimeException("Fail! -> UserGroup Not Found"));

        Set<UserGroup> newUserGroupSet = new HashSet<>();

        newUserGroupSet.add(userGroup);

        Student student = new Student();

        BeanUtils.copyProperties(lead,student);

        student.setCourse(course);
        student.setRegistrationFee(300);
        student.setBalance(course.getFee() - 300);
        student.setTransactionDate(LocalDateTime.now().toString());
        student.setRegistrationFeePaid(true);


        leadRepository.deleteByEmail(email);
        studentRepository.save(student);
        return student;

    }


    /**
     * @param l
     * @return
     */
    public DTOLeadResponse getLead(Lead l) {

        return new DTOLeadResponse(
                l.getEmail(),
                l.getFirstName(),
                l.getLastName(),
                l.getPhoneNumber(),
                l.getEmergencyPhone(),
                l.getClientStatus(),
                l.getRegistrationFee(),
                l.getDiscount(),
                l.getLeadStatus(),
                l.getLeadSource(),
                l.getComments(),
                l.getCurrentlyEmployed(),
                l.getCurrentlyITEmployed(),
                l.getDesiredJob(),
                l.getPaymentPlan(),
                l.getPaymentPlanStatus(),
                l.getRegistrationFeePaid(),
                l.getPlanAgreement(),
                l.getMailingStreet(),
                l.getMailingCity(),
                l.getMailingState(),
                l.getMailingZip(),
                l.getMailingCountry(),
                l.getCourse(),
                l.getCourseSchedule(),
                l.getTrainer(),
                l.getTrainingLocation(),
                l.getCreatedTime(),
                l.getModifiedTime()
        );

    }



} // Last

