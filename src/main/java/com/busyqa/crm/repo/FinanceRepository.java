package com.busyqa.crm.repo;

import com.busyqa.crm.model.finance.Discount;
import com.busyqa.crm.model.finance.LateFee;
import com.busyqa.crm.model.finance.Payment;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class FinanceRepository implements FinanceRepositoryI {
    @Override
    public List<Discount> getAllDiscount() {
        return null;
    }

    @Override
    public void addDiscount(Discount discount) {

    }

    @Override
    public Discount getDiscountById(long id) {
        return null;
    }

    @Override
    public List<LateFee> getAllLateFee() {
        return null;
    }

    @Override
    public void addLateFee(LateFee lateFee) {

    }

    @Override
    public LateFee getLateFeeById(long id) {
        return null;
    }

    @Override
    public List<Payment> getAllPayment() {
        return null;
    }

    @Override
    public void addPayment(Payment payment) {

    }

    @Override
    public Payment getPaymentById(long id) {
        return null;
    }
}
