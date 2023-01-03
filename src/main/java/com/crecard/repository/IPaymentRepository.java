package com.crecard.repository;

import com.crecard.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IPaymentRepository extends JpaRepository<Payment,Long> {
    void deletePaymentByPaymentId(long id);

    List<Payment> getPaymentsByCreditCardId(long id);
}
