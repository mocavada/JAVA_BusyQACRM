package com.busyqa.crm.repo;


import com.busyqa.crm.model.finance.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PaymentRepositoryI extends JpaRepository<Payment, Long> {

    @Query(value = "select * from payments p " +
            "join users s " +
            "on s.id =:id", nativeQuery = true)
    Iterable<Payment> getPaymentByStudentId(@Param("id") long id);


    @Query(value = "select * from payments p " +
            "join users s " +
            "on s.email =:email", nativeQuery = true)
    Iterable<Payment> getPaymentByStudentEmail(@Param("email") String email);

    List<Payment> findAllByStudent_Email(String email);

    List<Payment> findAllByStudent_Id(Long id);

    Page<Payment> findByStudent_Id(Long studentId, Pageable pageable);




//    Optional<Payment> findByIdAndUserId(Long id, Long userId);


}
