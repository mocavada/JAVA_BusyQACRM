package com.busyqa.crm.model.finance;

import com.busyqa.crm.model.clients.Student;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;

@Entity
@Table(name = "PAYMENTS")
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private double amount;
    private String remarks;
    // DATE
    @Basic
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Calendar paymentDate;

    // DATE
    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime modifiedTime;

    @ManyToOne(fetch=FetchType.EAGER)
    private Student student;


    public Payment() {
    }

    public Payment(double amount, String remarks, Calendar paymentDate, LocalDateTime createdTime, LocalDateTime modifiedTime, Student student) {
        this.amount = amount;
        this.remarks = remarks;
        this.paymentDate = paymentDate;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Calendar getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Calendar paymentDate) {
        this.paymentDate = paymentDate;
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

    //    @JsonIgnore
//    public double getPaidAmount() {
//        if( paymentStatus.equals(EnumList.PAID.toString())) {
//            return (regularFee + taxFee);
//        } else if (paymentStatus.equals(EnumList.PAID_WITH_LATE_FEE.toString())) {
//            return amount;
//        } else {
//            return 0;}
//    }
}
