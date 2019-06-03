package com.busyqa.crm.model.clients;

import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.finance.Payment;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="STUDENTS")
public class Student extends Lead {

    private double totalFee;
    private double balance;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Payment> payments = new ArrayList<>();

    public Student(double totalFee, double balance, List<Payment> payments) {
        this.totalFee = totalFee;
        this.balance = balance;
        this.payments = payments;
    }


    public Student(String firstName, String lastName, String email, String phone, String emergencyPhone, String clientStatus, double registrationFee, Course course, LocalDateTime createdTime, LocalDateTime modifiedTime, Instant lastActivityTime, String leadStatus, String leadSource, String comments, Boolean currentlyEmployed, Boolean currentlyITEmployed, String desiredJob, String mailingCity, String mailingCountry, String mailingState, String mailingStreet, String mailingZip, String paymentPlan, File planAgreement, String paymentPlanStatus, Boolean registrationFeePaid, double totalFee, double balance, List<Payment> payments) {
        super(firstName, lastName, email, phone, emergencyPhone, clientStatus, registrationFee, course, createdTime, modifiedTime, lastActivityTime, leadStatus, leadSource, comments, currentlyEmployed, currentlyITEmployed, desiredJob, mailingCity, mailingCountry, mailingState, mailingStreet, mailingZip, paymentPlan, planAgreement, paymentPlanStatus, registrationFeePaid);

        this.totalFee = totalFee;
        this.balance = balance;
        this.payments = payments;
    }

    public Student() {
    }

    public Student(String firstName, String lastName, String email, String phone, String emergencyPhone, String clientStatus, double registrationFee, Course course, LocalDateTime createdTime, LocalDateTime modifiedTime, Instant lastActivityTime, String leadStatus, String leadSource, String comments, Boolean currentlyEmployed, Boolean currentlyITEmployed, String desiredJob, String mailingCity, String mailingCountry, String mailingState, String mailingStreet, String mailingZip, String paymentPlan, File planAgreement, String paymentPlanStatus, Boolean registrationFeePaid) {
        super(firstName, lastName, email, phone, emergencyPhone, clientStatus, registrationFee, course, createdTime, modifiedTime, lastActivityTime, leadStatus, leadSource, comments, currentlyEmployed, currentlyITEmployed, desiredJob, mailingCity, mailingCountry, mailingState, mailingStreet, mailingZip, paymentPlan, planAgreement, paymentPlanStatus, registrationFeePaid);
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
