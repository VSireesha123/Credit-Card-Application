package com.crecard.interfaces;

import com.crecard.model.Payment;

import java.util.List;

public interface IPaymentService {
    public Payment addPayment(Payment payment);
    public Payment removePayment(long id);
    public Payment updatePayment(long id,Payment payment);
    public Payment getPayment(long id);

    public List<Payment> getCreditCardPayments(long id);

}
