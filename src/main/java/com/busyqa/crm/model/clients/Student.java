package com.busyqa.crm.model.clients;

import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.academics.CourseSchedule;
import com.busyqa.crm.model.academics.Trainer;
import com.busyqa.crm.model.academics.TrainingLocation;
import com.busyqa.crm.model.auth.UserGroup;
import com.busyqa.crm.model.finance.Payment;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "STUDENTS")
public class Student extends Lead {

    private double totalFee;
    private double balance;

    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Payment> payments = new ArrayList<>();

    public Student() {
    }

    public Student(double totalFee, double balance, List<Payment> payments) {
        this.totalFee = totalFee;
        this.balance = balance;
        this.payments = payments;
    }

    public Student(String username, String password, String email, String firstName, Set<UserGroup> usergroups, double totalFee, double balance, List<Payment> payments) {
        super(username, password, email, firstName, usergroups);
        this.totalFee = totalFee;
        this.balance = balance;
        this.payments = payments;
    }

    public Student(String clientStatus, double registrationFee, double discount, String transactionDate, String leadStatus, String leadSource, String comments, Boolean currentlyEmployed, Boolean currentlyITEmployed, String desiredJob, String paymentPlan, String paymentPlanStatus, Boolean registrationFeePaid, Boolean planAgreement, String mailingStreet, String mailingCity, String mailingState, String mailingZip, String mailingCountry, Course course, CourseSchedule courseSchedule, Trainer trainer, TrainingLocation trainingLocation, double totalFee, double balance, List<Payment> payments) {
        super(clientStatus, registrationFee, discount, transactionDate, leadStatus, leadSource, comments, currentlyEmployed, currentlyITEmployed, desiredJob, paymentPlan, paymentPlanStatus, registrationFeePaid, planAgreement, mailingStreet, mailingCity, mailingState, mailingZip, mailingCountry, course, courseSchedule, trainer, trainingLocation);
        this.totalFee = totalFee;
        this.balance = balance;
        this.payments = payments;
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
