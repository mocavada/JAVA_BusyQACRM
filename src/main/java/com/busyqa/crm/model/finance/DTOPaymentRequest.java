package com.busyqa.crm.model.finance;

import java.util.Calendar;

public class DTOPaymentRequest {

    private double amount;
    private String remarks;
    private Calendar paymentDate;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "student_id", referencedColumnName = "id")
//    @JsonIgnore
//    private Student student;


    public DTOPaymentRequest(double amount, String remarks, Calendar paymentDate) {
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

    public Calendar getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Calendar paymentDate) {
        this.paymentDate = paymentDate;
    }
}
