package com.busyqa.crm.repo;

import com.busyqa.crm.model.finance.Payment;

import java.util.List;

public interface IPaymentRepository {
    List<Payment> getAllPayment();
    void addPayment(Payment payment);
    Payment getPaymentById(long id);
    void updatePayment(Payment payment);
    void deletePaymentById(int id);
}
