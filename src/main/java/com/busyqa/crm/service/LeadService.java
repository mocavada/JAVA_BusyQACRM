package com.busyqa.crm.service;


import com.busyqa.crm.model.clients.DTOClient;
import com.busyqa.crm.model.clients.DTOLeadRequest;
import com.busyqa.crm.model.clients.Lead;
import com.busyqa.crm.model.clients.Student;
import com.busyqa.crm.model.util.EnumList;
import com.busyqa.crm.repo.AcademicsRepository;
import com.busyqa.crm.repo.FinanceRepository;
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

    @Autowired
    private AcademicsService academicsService;

    @Autowired
    private AcademicsRepository academicsRepository;

    @Autowired
    private FinanceRepository financeRepository;


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




    public List<DTOClient> getAllLeadsByDtypeAndUserState(String type, String state) {
        List<Lead> leads = leadRepository.findAllByDtypeAndUserStateOrderByIdDesc(type,state);
        if (leads.isEmpty()) throw new RuntimeException("Empty Lead list!");
        List<DTOClient> leadResponses = new ArrayList<>();
        System.out.println(leads.size());

        for (Lead l: leads) {
            leadResponses.add(getLead(l));
        }

        return leadResponses;
    }

    public List<DTOClient> getAllLeadsByDtypeAndUserStateAndClientStatus(String type, String state, String status) {

        List<Lead> leads = leadRepository.findAllByDtypeAndUserStateAndClientStatusOrderByIdDesc(type,state,status);
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
     * @param username
     * @return
     */
    public DTOClient getLeadByUsername(String username) {

        Lead l = leadRepository.findByUsername(username).orElseThrow(
                () -> new RuntimeException("Error: Username not found!"));
        return getLead(l);
    }




    /**
     * @param email
     * @param leadRequest
     * @return
     */
    public ResponseEntity<DTOClient> updateLead(String email, DTOLeadRequest leadRequest) {


        return leadRepository.findByEmail(email).map(l -> {

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


            l.setRegistrationFeePaid(leadRequest.getRegistrationFeePaid());
            l.setPlanAgreementSigned(leadRequest.getPlanAgreementSigned());
            l.setDiscountGiven(leadRequest.getDiscountGiven());

            l.setRegistrationFee(financeRepository
                    .getRegistrationFeeById(leadRequest.getRegistrationFee()));

            l.setDiscount(financeRepository
                    .getDiscountById(leadRequest.getDiscount()));

            l.setTax(financeRepository.getTaxById(leadRequest.getTax()));

            l.setPaymentPlan(financeRepository
                    .getPaymentPlanById(leadRequest.getPaymentPlan()));


            l.setCourse(academicsRepository
                    .getCourseById(leadRequest.getCourse()));

            l.setTotalCourseFee(

                    (academicsRepository.getCourseById(leadRequest.getCourse()).getFee()
                   + financeRepository.getRegistrationFeeById(leadRequest.getRegistrationFee()).getFee()
                   - financeRepository.getDiscountById(leadRequest.getDiscount()).getAmount())
                    * (1 + financeRepository.getTaxById(leadRequest.getTax()).getTaxRate())

            );


            l.setCourseSchedule(academicsRepository
                    .getCourseScheduleById(leadRequest.getCourseSchedule()));

            l.setTrainer( academicsRepository
                    .getTrainerById(leadRequest.getTrainer()));

            l.setTrainingLocation(academicsRepository
                    .getTrainingLocationById(leadRequest.getTrainingLocation()));


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

        Student student = new Student();

        student.setRegistrationFee(lead.getRegistrationFee());
        student.setDiscount(lead.getDiscount());
        student.setPaymentPlan(lead.getPaymentPlan());
        student.setCourse(lead.getCourse());
        student.setTotalCourseFee(lead.getTotalCourseFee());
        student.setCourseSchedule(lead.getCourseSchedule());
        student.setTrainer(lead.getTrainer());
        student.setTrainingLocation(lead.getTrainingLocation());

        BeanUtils.copyProperties(lead,student);


        leadRepository.deleteByEmail(email);

        Student saveStudent = studentRepository.save(student);
        return saveStudent;

    }

    // FOR ADMIN
    /**
     * @param email
     * @return
     */
    public Lead changeLeadToEmployee(String email) {

        Lead lead = leadRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Fail! -> Lead Not Found"));


//        List<UserGroup> usergroups = userGroupRepository.findAll();

        lead.setUserState(EnumList.EMPLOYEE.toString());
        Lead saveEmployee = leadRepository.save(lead);
        return saveEmployee;

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

                l.getDtype(),
                l.getUserState(),
                l.getUsergroups(),


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
                l.getTax(),
                l.getPaymentPlan(),
                l.getCourse(),
                l.getTotalCourseFee(),
                l.getCourseSchedule(),
                l.getTrainer(),
                l.getTrainingLocation()
                // !* create logic

                // !* create logic

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

