package com.busyqa.crm.model.finance;

import com.busyqa.crm.model.clients.Student;

import java.util.Calendar;

public class DTOPaymentResponse {
    private double amount;
    private String remarks;
    private Calendar paymentDate;
    private Student student;

    public DTOPaymentResponse(double amount, String remarks, Calendar paymentDate, Student student) {
        this.amount = amount;
        this.remarks = remarks;
        this.paymentDate = paymentDate;
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

    public Calendar getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Calendar paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
