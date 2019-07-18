package com.busyqa.crm.service;

import com.busyqa.crm.model.finance.*;
import com.busyqa.crm.repo.FinanceRepositoryI;
import com.busyqa.crm.repo.PaymentRepositoryI;
import com.busyqa.crm.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class FinanceService {

    @Autowired
    private FinanceRepositoryI financeRepository;

    @Autowired
    private PaymentRepositoryI paymentRepository;

    @Autowired
    private StudentRepository studentRepository;


    // DISCOUNT
    //////////////
    public List<Discount> getAllDiscount() {
        return financeRepository.getAllDiscount(); }


    public Discount getDiscountById(long id) {
        return financeRepository.getDiscountById(id);
    }

    public synchronized boolean addDiscount(Discount discount) {
        if( financeRepository.discountExist(discount.getAmount())) {
            return false;
        } else {
            financeRepository.addDiscount(discount);
            return true;
        }
    }


    // LATE FEE
    //////////////
    public List<LateFee> getAllLateFee() {
        return financeRepository.getAllLateFee(); }


    public LateFee getLateFeeById(long id) {

        return financeRepository.getLateFeeById(id);
    }

    public synchronized boolean addLateFee(LateFee lateFee) {
        if( financeRepository.lateFeeExist(lateFee.getFee())) {
            return false;
        } else {
            financeRepository.addLateFee(lateFee);
            return true;
        }
    }


    // PAYMENT ??
    //////////////
    public List<Payment> getAllPayment() {
        return financeRepository.getAllPayment(); }


    public Payment getPaymentById(long id) {
        return financeRepository.getPaymentById(id);
    }

    // PAYMENT PLAN
    //////////////
    public List<PaymentPlan> getAllPaymentPlan() {
        return financeRepository.getAllPaymentPlan(); }


    public PaymentPlan getPaymentPlanById(long id) {
        return financeRepository.getPaymentPlanById(id);
    }

    public synchronized boolean addPaymentPlan(PaymentPlan paymentPlan) {
        if( financeRepository.paymentPlanExist(paymentPlan.getName())) {
            return false;
        } else {
            financeRepository.addPaymentPlan(paymentPlan);
            return true;
        }
    }

    public List<Payment> getAllPaymentsByStudent(long id) {
        return financeRepository.getAllPaymentsByStudent(id);
    }

    public List<Payment> getPaymentsByStudentId(long id) {
        return (List<Payment>) paymentRepository.getPaymentByStudentId(id);
    }

    public List<Payment> getPaymentsByStudenEmail(String email) {
        return (List<Payment>) paymentRepository.getPaymentByStudentEmail(email);
    }


    /**
     * @return
     */
    public List<Payment> getAllPaymentsByEmail(String email) {

        List<Payment> payments = paymentRepository.findAllByStudent_Email(email);

        if (payments.isEmpty()) throw new RuntimeException("No Payments for this Student!");

        return payments;

    }

    public synchronized boolean addPayment(Payment payment) {

        if( financeRepository.studentExist(payment.getStudent().getId())) {
            return false;
        } else {
            financeRepository.addPayment(payment);
            return true;
        }

    }










    // REGISTRATION FEE
    //////////////
    public List<RegistrationFee> getAllRegistrationFee() {
        return financeRepository.getAllRegistrationFee(); }


    public RegistrationFee getRegistrationFeeById(long id) {

        return financeRepository.getRegistrationFeeById(id);
    }

    public synchronized boolean addRegistrationFee(RegistrationFee registrationFee) {
        if( financeRepository.registrationFeeExist(registrationFee.getFee())) {
            return false;
        } else {
            financeRepository.addRegistrationFee(registrationFee);
            return true;
        }
    }


    // TAX
    //////////////
    public List<Tax> getAllTax() {
        return financeRepository.getAllTax(); }


    public Tax getTaxById(long id) {

        return financeRepository.getTaxById(id);
    }

    public synchronized boolean addTax(Tax tax) {
        if( financeRepository.taxExist(tax.getTaxRate())) {
            return false;
        } else {
            financeRepository.addTax(tax);
            return true;
        }
    }

}
