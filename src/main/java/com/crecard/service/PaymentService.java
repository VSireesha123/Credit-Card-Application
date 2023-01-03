package com.crecard.service;

import com.crecard.execption.CustomException;
import com.crecard.interfaces.IPaymentService;
import com.crecard.model.Payment;
import com.crecard.repository.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    IPaymentRepository paymentRepository;

    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment removePayment(long id) {
        return paymentRepository.deletePaymentByPaymentId(id);
    }

    @Override
    public Payment updatePayment(long id, Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPayment(long id) {
        Optional<Payment> payment= paymentRepository.findById(id);
        return payment.orElseThrow(()-> new CustomException("Payment Not Exists with id :"+id));
    }

    @Override
    public List<Payment> getCreditCardPayments(long id) {
        return paymentRepository.getPaymentsByCreditCardId(id);
    }
}
