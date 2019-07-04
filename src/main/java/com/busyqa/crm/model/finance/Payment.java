package com.busyqa.crm.model.finance;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "PAYMENTS")
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private String remarks;
    // DATE
    @CreationTimestamp
    private LocalDateTime paymentDate;


    public Payment() {
    }

    public Payment(double amount, String remarks, LocalDateTime paymentDate) {
        this.amount = amount;
        this.remarks = remarks;
        this.paymentDate = paymentDate;
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

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
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
