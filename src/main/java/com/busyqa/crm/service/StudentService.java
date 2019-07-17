package com.busyqa.crm.service;

import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.clients.DTOClient;
import com.busyqa.crm.model.clients.Student;
import com.busyqa.crm.repo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    /**
     * @return
     */
    public List<DTOClient> getAllByDtype(String type) {

        List<Student> students = studentRepository.findAllByDtype(type);

        if (students.isEmpty()) throw new RuntimeException("Empty Student list!");

        List<DTOClient> studentResponses = new ArrayList<>();

        System.out.println(students.size());

        for (Student l: students) {
            studentResponses.add(getStudent(l));
        }

        return studentResponses;

    }

    /**
     * @param email
     * @return
     */
    public DTOClient getStudentByEmail(String email) {

        Student student = studentRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Error: Email not found!"));

        return getStudent(student);
    }

    /**
     * @param email
     * @param studentRequest
     * @return
     */
    public ResponseEntity<DTOClient> updateStudent(String email, DTOClient studentRequest) {

        return studentRepository.findByEmail(email).map(l -> {

            Course course = academicsRepository.findByCourseName(studentRequest
                    .getCourse().getName()).orElseThrow(() -> new RuntimeException("Fail! -> No Course Found"));

            // !* create logic
            l.getAmountPaid();
            // !* create logic
            l.getBalance();
            // !* create logic
            l.getWeeklyPayment();
            l.setPaymentLate(studentRequest.getPaymentLate());
            l.setPayments(studentRequest.getPayments());
            l.setTax(studentRequest.getTax());
            l.setLateFee(studentRequest.getLateFee());


            this.studentRepository.save(l);

            DTOClient studentResponse = new DTOClient();
            BeanUtils.copyProperties(studentRequest, studentResponse);

            return ResponseEntity.ok().body(studentResponse);
        }).orElse(ResponseEntity.notFound().build());

    }

    /** HELPER METHOD
     * @param l
     * @return
     */
    public DTOClient getStudent(Student l) {

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
                l.getTrainingLocation(),


                l.getAmountPaid(),
                l.getBalance(),
                l.getWeeklyPayment(),
                l.getPaymentLate(),
                l.getPayments(),
                l.getLateFee()
        );

    }



}
