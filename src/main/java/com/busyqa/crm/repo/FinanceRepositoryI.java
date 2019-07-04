package com.busyqa.crm.repo;

import com.busyqa.crm.model.finance.Discount;
import com.busyqa.crm.model.finance.LateFee;
import com.busyqa.crm.model.finance.Payment;

import java.util.List;

public interface FinanceRepositoryI {

    //DISCOUNT
    List<Discount> getAllDiscount();
    void addDiscount(Discount discount);
    Discount getDiscountById(long id);

    //LATE FEE
    List<LateFee> getAllLateFee();
    void addLateFee(LateFee lateFee);
    LateFee getLateFeeById(long id);

    //PAYMENT
    List<Payment> getAllPayment();
    void addPayment(Payment payment);
    Payment getPaymentById(long id);
}
