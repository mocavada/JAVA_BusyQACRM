package com.busyqa.crm.service;

import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.clients.DTOClientRequest;
import com.busyqa.crm.model.clients.DTOClientResponse;
import com.busyqa.crm.model.clients.Student;
import com.busyqa.crm.model.finance.Payment;
import com.busyqa.crm.repo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private IUserGroupRepository userGroupRepository;

    @Autowired
    private IAcademicsRepository academicsRepository;

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private ILeadRepository leadRepository;

    @Autowired
    private IInternRepository internRepository;

    @Autowired
    private IPaymentRepository paymentRepository;

    @Autowired
    private PaymentService paymentService;

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
    public DTOClientResponse getStudentByEmail(String email) {

        Student student = studentRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Error: Email not found!"));

        List<Payment> payments = paymentService.updatePayments(student.getId(),student.getCourse().getName());

        double feeNeedToPay = 0;
        for (Payment p : payments) {
            feeNeedToPay += p.getAmount();
        }

        student.setAmountPaid(paymentService.getUpdatePaidAmount(student.getId()));
        student.setBalance(feeNeedToPay - student.getAmountPaid());

        studentRepository.save(student);

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
            l.setRegistrationFee(studentRequest.getRegistrationFee());
            l.setDiscount(studentRequest.getDiscount());

            l.setTransactionDate(LocalDateTime.now().toString());
            l.setLeadStatus(studentRequest.getLeadStatus());
            l.setLeadSource(studentRequest.getLeadSource());
            l.setComments(studentRequest.getComments());
            l.setCurrentlyEmployed(studentRequest.getCurrentlyEmployed());
            l.setCurrentlyITEmployed(studentRequest.getCurrentlyITEmployed());
            l.setDesiredJob(studentRequest.getDesiredJob());
            l.setPaymentPlan(studentRequest.getPaymentPlan());
            l.setPaymentPlanStatus(studentRequest.getPaymentPlanStatus());
            l.setRegistrationFeePaid(studentRequest.getRegistrationFeePaid());
            l.setPlanAgreement(studentRequest.getPlanAgreement());
            l.setMailingStreet(studentRequest.getMailingStreet());
            l.setMailingCity(studentRequest.getMailingCity());
            l.setMailingState(studentRequest.getMailingState());
            l.setMailingZip(studentRequest.getMailingZip());
            l.setMailingCountry(studentRequest.getMailingCountry());

            l.setCourse(studentRequest.getCourse());
            l.setCourseSchedule(studentRequest.getCourseSchedule());
            l.setTrainer(studentRequest.getTrainer());
            l.setTrainingLocation(studentRequest.getTrainingLocation());

            l.setAmountPaid((studentRequest.getAmountPaid()));
            l.updateBalance();

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
                l.getModifiedTime(),
                l.getAmountPaid(),
                l.getBalance()
        );

    }



}
