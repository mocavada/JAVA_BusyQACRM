package com.busyqa.crm.repo;

import com.busyqa.crm.model.clients.Student;
import com.busyqa.crm.model.finance.Payment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Repository
public class PaymentRepositoryRepository implements IPaymentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Payment> getAllPayment() {
        String jpql = "SELECT j FROM Student j ORDER BY j.id";

        return (List<Payment>) entityManager.createQuery(jpql)
                .getResultStream()
                .collect(Collectors.toList());
    }

    @Override
    public void addPayment(Payment payment) {
        entityManager.persist(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return entityManager.find(Payment.class,id);
    }

    @Override
    public void updatePayment(Payment payment) {
        Payment updatePayment = getPaymentById(payment.getId());
        updatePayment.setAmount(payment.getAmount());
        updatePayment.setTransactionCode(payment.getTransactionCode());
        updatePayment.setStudent(payment.getStudent());

        entityManager.flush();

    }

    @Override
    public void deletePaymentById(int id) {
        entityManager.remove(id);
    }
}
