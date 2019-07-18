package com.busyqa.crm.model.clients;

import com.busyqa.crm.model.finance.Payment;

public class DTOStudentRequest {

    private Boolean isPaymentLate;
    private Long lateFee;
    private Payment payments;



    public DTOStudentRequest() {
    }

    public DTOStudentRequest(Boolean isPaymentLate, Long lateFee, Payment payments) {
        this.isPaymentLate = isPaymentLate;
        this.lateFee = lateFee;
        this.payments = payments;
    }



    public Boolean getPaymentLate() {
        return isPaymentLate;
    }

    public void setPaymentLate(Boolean paymentLate) {
        isPaymentLate = paymentLate;
    }

    public Long getLateFee() {
        return lateFee;
    }

    public void setLateFee(Long lateFee) {
        this.lateFee = lateFee;
    }

    public Payment getPayments() {
        return payments;
    }

    public void setPayments(Payment payments) {
        this.payments = payments;
    }
}
