package com.busyqa.crm.repo;

import com.busyqa.crm.model.finance.*;

import java.util.List;

public interface FinanceRepositoryI {

    //DISCOUNT
    List<Discount> getAllDiscount();
    void addDiscount(Discount discount);
    Discount getDiscountById(long id);
    boolean discountExist(Double amount);

    //LATE FEE
    List<LateFee> getAllLateFee();
    void addLateFee(LateFee lateFee);
    LateFee getLateFeeById(long id);
    boolean lateFeeExist(Double fee);

    //PAYMENT
    List<Payment> getAllPayment();
    Payment getPaymentById(long id);
    List<Payment> getAllPaymentsByStudent(long id);


    //PAYMENT PLAN
    List<PaymentPlan> getAllPaymentPlan();
    void addPaymentPlan(PaymentPlan paymentPlan);
    PaymentPlan getPaymentPlanById(long id);
    boolean paymentPlanExist(String name);

    //REGISTRATION
    List<RegistrationFee> getAllRegistrationFee();
    void addRegistrationFee(RegistrationFee registrationFee);
    RegistrationFee getRegistrationFeeById(long id);
    boolean registrationFeeExist(Double fee);

    //TAX
    List<Tax> getAllTax();
    void addTax(Tax tax);
    Tax getTaxById(long id);
    boolean taxExist(Double taxRate);
}
