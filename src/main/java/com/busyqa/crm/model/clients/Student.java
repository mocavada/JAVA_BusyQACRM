package com.busyqa.crm.model.clients;

import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.academics.CourseSchedule;
import com.busyqa.crm.model.academics.Trainer;
import com.busyqa.crm.model.academics.TrainingLocation;
import com.busyqa.crm.model.auth.UserGroup;
import com.busyqa.crm.model.finance.Payment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "STUDENTS")
public class Student extends Lead {

    private double amountPaid;
    private double balance;

    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Payment> payments = new ArrayList<>();

    public Student() {
    }

    public Student(double amountPaid, double balance, List<Payment> payments) {
        this.amountPaid = amountPaid;
        this.balance = balance;
        this.payments = payments;
    }


    public Student(String username, String password, String email, String firstName, Set<UserGroup> usergroups, String clientStatus, double registrationFee, double discount, String transactionDate, String leadStatus, String leadSource, String comments, Boolean currentlyEmployed, Boolean currentlyITEmployed, String desiredJob, String paymentPlan, String paymentPlanStatus, Boolean registrationFeePaid, Boolean planAgreement, String mailingStreet, String mailingCity, String mailingState, String mailingZip, String mailingCountry, Course course, CourseSchedule courseSchedule, Trainer trainer, TrainingLocation trainingLocation, double amountPaid, double balance, List<Payment> payments) {
        super(username, password, email, firstName, usergroups, clientStatus, registrationFee, discount, transactionDate, leadStatus, leadSource, comments, currentlyEmployed, currentlyITEmployed, desiredJob, paymentPlan, paymentPlanStatus, registrationFeePaid, planAgreement, mailingStreet, mailingCity, mailingState, mailingZip, mailingCountry, course, courseSchedule, trainer, trainingLocation);
        this.amountPaid = amountPaid;
        this.balance = balance;
        this.payments = payments;
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

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @JsonIgnore
    public double getClassFee() {
        return this.getCourse().getFee();
    }


    @JsonIgnore
    public void updateBalance() {
        this.setBalance(this.getClassFee() - this.getAmountPaid());
    }



    public Calendar getDateStart() {
        return this.getCourseSchedule().getDateStart();
    }

    public Calendar getDateEnd() {
        return this.getCourseSchedule().getDateEnd();
    }
}
