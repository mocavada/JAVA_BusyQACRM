package com.busyqa.crm.repo;

import com.busyqa.crm.model.finance.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
@Transactional
@Repository
public class FinanceRepository implements FinanceRepositoryI {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Discount> getAllDiscount() {
        String jpql = "SELECT j FROM Discount j ORDER BY j.id DESC";
        return (List<Discount>) entityManager.createQuery(jpql)
                .setMaxResults(12)
                .getResultStream()
                .collect(Collectors.toList());
    }

    @Override
    public void addDiscount(Discount discount) {
        entityManager.persist(discount);
    }

    @Override
    public Discount getDiscountById(long id) {
        return entityManager.find(Discount.class,id);
    }

    @Override
    public boolean discountExist(Double amount) {
        String jpql = "from Discount as a WHERE a.amount =: amount";

        int count = entityManager.createQuery(jpql)
                .setParameter("amount",amount)
                .getResultList().size();

        return count > 0;
    }

    @Override
    public List<LateFee> getAllLateFee() {
        String jpql = "SELECT j FROM LateFee j ORDER BY j.id DESC";
        return (List<LateFee>) entityManager.createQuery(jpql)
                .setMaxResults(12)
                .getResultStream()
                .collect(Collectors.toList());
    }

    @Override
    public void addLateFee(LateFee lateFee) {
        entityManager.persist(lateFee);
    }

    @Override
    public LateFee getLateFeeById(long id) {

        return entityManager.find(LateFee.class,id);
    }

    @Override
    public boolean lateFeeExist(Double fee) {
        String jpql = "from LateFee as a WHERE a.fee =: fee";

        int count = entityManager.createQuery(jpql)
                .setParameter("fee",fee)
                .getResultList().size();

        return count > 0;
    }

    @Override
    public List<Payment> getAllPayment() {
        String jpql = "SELECT j FROM Payment j ORDER BY j.id DESC";
        return (List<Payment>) entityManager.createQuery(jpql)
                .setMaxResults(12)
                .getResultStream()
                .collect(Collectors.toList());
    }


    @Override
    public List<Payment> getAllPaymentsByStudent(long id) {
    String jpql = "SELECT p FROM Payment p INNER JOIN p.student s ON s.id =: id";

    return (List<Payment>) entityManager.createQuery(jpql)
            .setParameter("id",id)
            .getResultStream()
            .collect(Collectors.toList());
    }


    @Override
    public Payment getPaymentById(long id) {

        return entityManager.find(Payment.class,id);
    }



    @Override
    public List<PaymentPlan> getAllPaymentPlan() {
        String jpql = "SELECT j FROM PaymentPlan j ORDER BY j.id";
        return (List<PaymentPlan>) entityManager.createQuery(jpql)
                .getResultStream()
                .collect(Collectors.toList());
    }

    @Override
    public void addPaymentPlan(PaymentPlan paymentPlan) {
        entityManager.persist(paymentPlan);
    }

    @Override
    public PaymentPlan getPaymentPlanById(long id) {
        return entityManager.find(PaymentPlan.class,id);
    }

    @Override
    public boolean paymentPlanExist(String name) {
        String jpql = "from PaymentPlan as a WHERE a.name =: name";

        int count = entityManager.createQuery(jpql)
                .setParameter("name",name)
                .getResultList().size();

        return count > 0;
    }

    @Override
    public List<RegistrationFee> getAllRegistrationFee() {
        String jpql = "SELECT j FROM RegistrationFee j ORDER BY j.id";
        return (List<RegistrationFee>) entityManager.createQuery(jpql)
                .getResultStream()
                .collect(Collectors.toList());
    }

    @Override
    public void addRegistrationFee(RegistrationFee registrationFee) {
        entityManager.persist(registrationFee);
    }

    @Override
    public RegistrationFee getRegistrationFeeById(long id) {
        return entityManager.find(RegistrationFee.class,id);
    }

    @Override
    public boolean registrationFeeExist(Double fee) {
        String jpql = "from RegistrationFee as a WHERE a.fee =: fee";

        int count = entityManager.createQuery(jpql)
                .setParameter("fee",fee)
                .getResultList().size();

        return count > 0;
    }

    @Override
    public List<Tax> getAllTax() {
        String jpql = "SELECT j FROM Tax j ORDER BY j.id";
        return (List<Tax>) entityManager.createQuery(jpql)
                .getResultStream()
                .collect(Collectors.toList());
    }

    @Override
    public void addTax(Tax tax) {
        entityManager.persist(tax);
    }

    @Override
    public Tax getTaxById(long id) {
        return entityManager.find(Tax.class,id);
    }

    @Override
    public boolean taxExist(Double taxRate) {
        String jpql = "from Tax as a WHERE a.taxRate =: taxRate";

        int count = entityManager.createQuery(jpql)
                .setParameter("taxRate",taxRate)
                .getResultList().size();

        return count > 0;
    }
}
