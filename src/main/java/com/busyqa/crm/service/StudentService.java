package com.busyqa.crm.service;

import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.clients.DTOClientRequest;
import com.busyqa.crm.model.clients.DTOClientResponse;
import com.busyqa.crm.model.clients.Student;
import com.busyqa.crm.repo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private UserGroupRepository userGroupRepository;

    @Autowired
    private AcademicsRepositoryI academicsRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private InternRepository internRepository;

//    @Autowired
//    private IPaymentRepository paymentRepository;


    /**
     * @return
     */
    public List<DTOClientResponse> getAllStudents() {

        List<Student> students = studentRepository.findAll();

        if (students.isEmpty()) throw new RuntimeException("Empty Student list!");

        List<DTOClientResponse> studentResponse = new ArrayList<>();

        System.out.println(students.size());

        for (Student l: students) {
            studentResponse.add(getStudent(l));
        }
        return studentResponse;
    }

    /**
     * @param email
     * @return
     */
    public DTOClientResponse getStudentByEmail(String email) throws ParseException {

        Student student = studentRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Error: Email not found!"));

        return getStudent(student);
    }

    /**
     * @param email
     * @param studentRequest
     * @return
     */
    public ResponseEntity<DTOClientResponse> updateStudent(String email, DTOClientRequest studentRequest) {

        return studentRepository.findByEmail(email).map(l -> {

            Course course = academicsRepository.findByCourseName(studentRequest
                    .getCourse().getName()).orElseThrow(() -> new RuntimeException("Fail! -> No Course Found"));

            l.setEmail(studentRequest.getEmail());
            l.setFirstName(studentRequest.getFirstName());
            l.setLastName(studentRequest.getLastName());
            l.setPhoneNumber(studentRequest.getPhoneNumber());
            l.setEmergencyPhone(studentRequest.getEmergencyPhone());

            l.setClientStatus(studentRequest.getClientStatus());
            l.setLeadSource(studentRequest.getLeadSource());
            l.setComments(studentRequest.getComments());
            l.setCurrentlyEmployed(studentRequest.getCurrentlyEmployed());
            l.setCurrentlyITEmployed(studentRequest.getCurrentlyITEmployed());
            l.setDesiredJob(studentRequest.getDesiredJob());

            l.setMailingStreet(studentRequest.getMailingStreet());
            l.setMailingCity(studentRequest.getMailingCity());
            l.setMailingState(studentRequest.getMailingState());
            l.setMailingZip(studentRequest.getMailingZip());
            l.setMailingCountry(studentRequest.getMailingCountry());

            l.setRegistrationFeePaid(studentRequest.getRegistrationFeePaid());
            l.setPlanAgreementSigned(studentRequest.getPlanAgreementSigned());
            l.setDiscountGiven(studentRequest.getDiscountGiven());

            l.setRegistrationFee(studentRequest.getRegistrationFee());
            l.setDiscount(studentRequest.getDiscount());
            l.setPaymentPlan(studentRequest.getPaymentPlan());

            l.setCourse(studentRequest.getCourse());
            l.setTotalCourseFee(studentRequest.getTotalCourseFee());
            l.setCourseSchedule(studentRequest.getCourseSchedule());
            l.setTrainer(studentRequest.getTrainer());
            l.setTrainingLocation(studentRequest.getTrainingLocation());

            l.getAmountPaid();
            l.getBalance();
            l.getWeeklyPayment();

            l.setPaymentLate(studentRequest.getPaymentLate());


            l.setPayments(studentRequest.getPayments());
            l.setTaxRate(studentRequest.getTaxRate());
            l.setLateFee(studentRequest.getLateFee());


            this.studentRepository.save(l);

            DTOClientResponse studentResponse = new DTOClientResponse();
            BeanUtils.copyProperties(studentRequest, studentResponse);

            return ResponseEntity.ok().body(studentResponse);
        }).orElse(ResponseEntity.notFound().build());

    }


    /** HELPER METHOD
     * @param l
     * @return
     */
    public DTOClientResponse getStudent(Student l) {

        return new DTOClientResponse(
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
                l.getTrainingLocation(),


                l.getAmountPaid(),
                l.getBalance(),
                l.getWeeklyPayment(),
                l.getPaymentLate(),
                l.getPayments(),
                l.getTaxRate(),
                l.getLateFee()
        );

    }



}
