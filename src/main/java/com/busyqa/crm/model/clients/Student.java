package com.busyqa.crm.model.clients;

import com.busyqa.crm.model.academics.Class;
import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.finance.Payment;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
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


    public Student() {
        super();
    }

    public Student(double totalFee, double balance, List<Payment> payments) {
        this.totalFee = totalFee;
        this.balance = balance;
        this.payments = payments;
    }

    public Student(String firstName, String lastName, String phone, String email, String status, String leadSource, String comments, double registrationFee, Course course, double totalFee, double balance, List<Payment> payments) {
        super(firstName, lastName, phone, email, status, leadSource, comments, registrationFee, course);
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
