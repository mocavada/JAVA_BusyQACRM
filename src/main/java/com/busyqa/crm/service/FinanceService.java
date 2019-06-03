package com.busyqa.crm.service;


import com.busyqa.crm.model.finance.Payment;
import com.busyqa.crm.repo.IFinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class FinanceService {

    @Autowired
    private IFinanceRepository financeRepository;

    // PAYMENT //
    public List<Payment> getAllPayment() { return financeRepository.getAllPayment(); }
    public void addPayment(Payment payment) { financeRepository.addPayment(payment); }
    public void updatePayment(Payment payment) { financeRepository.updatePayment(payment); }
    public Payment getPaymentById(long id) { return financeRepository.getPaymentById(id); }
    public void deletePaymentById(int id) { financeRepository.deletePaymentById(id); }


}
