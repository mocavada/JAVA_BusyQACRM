package com.busyqa.crm.model.finance;

import com.busyqa.crm.model.EnumList;
import com.busyqa.crm.model.clients.Intern;
import com.busyqa.crm.model.clients.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "PAYMENTS")
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private double regularFee;
    private double taxFee;
    private double lateFee;
    private double amount;

    private String paymentStatus;

    private String transactionCode;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Student student;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "intern_id",referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Intern intern;


    // DATE
    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime modifiedTime;

    //
    public Payment() {
    }

    // Students
    public Payment(String date, double regularFee, double taxFee, double lateFee, double amount, String paymentStatus) {
        this.date = date;
        this.regularFee = regularFee;
        this.taxFee = taxFee;
        this.lateFee = lateFee;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Intern getIntern() {
        return intern;
    }

    public void setIntern(Intern intern) {
        this.intern = intern;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRegularFee() {
        return regularFee;
    }

    public void setRegularFee(double regularFee) {
        this.regularFee = regularFee;
    }

    public double getTaxFee() {
        return taxFee;
    }

    public void setTaxFee(double taxFee) {
        this.taxFee = taxFee;
    }

    public double getLateFee() {
        return lateFee;
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @JsonIgnore
    public double getPaidAmount() {
        if( paymentStatus.equals(EnumList.PAID.toString())) {
            return (regularFee + taxFee);
        } else if (paymentStatus.equals(EnumList.PAID_WITH_LATE_FEE.toString())) {
            return amount;
        } else {
            return 0;}
    }
}
