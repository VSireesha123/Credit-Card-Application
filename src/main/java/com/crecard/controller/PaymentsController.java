package com.crecard.controller;

import com.crecard.model.Account;
import com.crecard.model.Address;
import com.crecard.model.Payment;
import com.crecard.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentsController {
    
    @Autowired
    PaymentService paymentService;


    @PutMapping("/{id}")
    public Payment  update(@RequestBody Payment payment, @PathVariable("id") long id){
        return paymentService.updatePayment(id,payment);
    }

    @PostMapping
    public Payment create(@RequestBody Payment payment){
        return paymentService.addPayment(payment);
    }

    @DeleteMapping("/{id}")
    public Payment delete(@PathVariable("id") long id){
        return paymentService.removePayment(id);
    }
    @GetMapping("/{id}")
    public Payment show(@PathVariable("id") long id){return  paymentService.getPayment(id);}

    @GetMapping("/credit_card/{id}")
    public List<Payment> getCreditCardPayments(@PathVariable("id") long id){
        return paymentService.getCreditCardPayments(id);
    }
    
}
