package com.busyqa.crm.model.clients;

import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.academics.CourseSchedule;
import com.busyqa.crm.model.academics.Trainer;
import com.busyqa.crm.model.academics.TrainingLocation;
import com.busyqa.crm.model.auth.UserGroup;
import com.busyqa.crm.model.finance.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "STUDENTS")
public class Student extends Lead {

    private double amountPaid;
    private double balance;
    private double weeklyPayment;
    private Boolean isPaymentLate;

    @OneToMany(cascade = PERSIST, mappedBy = "student")
    private List<Payment> payments = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name="lateFee_id")
    private LateFee lateFee;


    public Student() {
    }

    public Student(String username, String password, String email, String firstName, Set<UserGroup> usergroups, String clientStatus, String leadSource, String comments, Boolean isCurrentlyEmployed, Boolean isCurrentlyITEmployed, String desiredJob, String mailingStreet, String mailingCity, String mailingState, String mailingZip, String mailingCountry, Boolean isRegistrationFeePaid, Boolean isPlanAgreementSigned, Boolean isDiscountGiven, RegistrationFee registrationFee, Discount discount, Tax taxRate, PaymentPlan paymentPlan, Course course, double totalCourseFee, CourseSchedule courseSchedule, Trainer trainer, TrainingLocation trainingLocation, double amountPaid, double balance, double weeklyPayment, Boolean isPaymentLate, List<Payment> payments, LateFee lateFee) {
        super(username, password, email, firstName, usergroups, clientStatus, leadSource, comments, isCurrentlyEmployed, isCurrentlyITEmployed, desiredJob, mailingStreet, mailingCity, mailingState, mailingZip, mailingCountry, isRegistrationFeePaid, isPlanAgreementSigned, isDiscountGiven, registrationFee, discount, taxRate, paymentPlan, course, totalCourseFee, courseSchedule, trainer, trainingLocation);
        this.amountPaid = amountPaid;
        this.balance = balance;
        this.weeklyPayment = weeklyPayment;
        this.isPaymentLate = isPaymentLate;
        this.payments = payments;
        this.lateFee = lateFee;
    }

    public void setWeeklyPayment(double weeklyPayment) {

        this.weeklyPayment = weeklyPayment;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public Boolean getPaymentLate() {
        return isPaymentLate;
    }

    public void setPaymentLate(Boolean paymentLate) {
        isPaymentLate = paymentLate;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }


    public LateFee getLateFee() {
        return lateFee;
    }

    public void setLateFee(LateFee lateFee) {
        this.lateFee = lateFee;
    }

    public double getWeeklyPayment() {
        return weeklyPayment;
    }



    // CUSTOM METHODS

//    public double getWeeklyPayment() {
//        return this.weeklyPayment = (this.getTotalCourseFee()) / this.getPaymentPlan().getWeekFrequency();
//    }
//
//    public void addPayment(Payment payment) {
//        this.payments.add(payment);
//    }
//
//    public double getTotalPayments() {
//        double sum = payments.stream()
//                .filter(o -> o.getAmount() > 10)
//                .mapToDouble(o -> o.getAmount()).sum();
//        return sum;
//    }
//
//
//    public double getTotalBalance() {
//        if(isPaymentLate) {
//            return (this.getTotalCourseFee() * (1 + this.taxRate.getTaxRate()))
//                    - this.getTotalPayments()
//                    + this.lateFee.getFee();
//        } else {
//            return (this.getTotalCourseFee() * (1 + this.taxRate.getTaxRate()))
//                    - this.getTotalPayments();
//        }
//    }
//
//
//    public Map<String, Double> getPaymentSchedules() {
//
//        Double weeklyPayment = this.getWeeklyPayment();
//
//        Calendar courseStartDate = this.getCourseSchedule().getDateStart();
//        Date dateX = courseStartDate.getTime();
//        Calendar calendarX = Calendar.getInstance();
//        calendarX.setTime(dateX);
//        int startWeek = calendarX.get(Calendar.WEEK_OF_YEAR);
//
//        for (int i = startWeek; i < startWeek + this.getPaymentPlan().getWeekFrequency(); i++) {
//
//            calendarX.set(Calendar.WEEK_OF_YEAR, i);
//            Calendar calDate = this.dateToCalendar(calendarX.getTime());
//            paymentSchedules.put(calDate.toString(), weeklyPayment);
//        }
//        return this.paymentSchedules;
//    }
//
//
//    public Calendar getDateStart() {
//        return this.getCourseSchedule().getDateStart();
//    }
//
//    public Calendar getDateEnd() {
//        return this.getCourseSchedule().getDateEnd();
//    }
//
//    //HELPER METHOD
//    //Convert Date to Calendar
//    private Calendar dateToCalendar(Date date) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        return calendar;
//
//    }



    //    @JsonIgnore
//    public void updateBalance() {
//        this.setBalance(this.getClassFee() - this.getAmountPaid());
//    }
}
