package com.crecard.repository;

import com.crecard.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Payment deletePaymentByPaymentId(long id);

    List<Payment> getPaymentsByCreditCardId(long id);
}
