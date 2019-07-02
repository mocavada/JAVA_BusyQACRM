package com.busyqa.crm.repo;

import com.busyqa.crm.model.finance.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {
    Page<Payment> findByStudentId(Long studentId, Pageable pageable);
    Optional<Payment> findByIdAndStudentId(Long id, Long studentId);

}

