package com.crecard.controller;

import com.crecard.model.Account;
import com.crecard.model.Address;
import com.crecard.model.Payment;
import com.crecard.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentsController {
    
    @Autowired
    PaymentService paymentService;


    @PutMapping("/updatePayment/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Payment  updatePayment(@RequestBody Payment payment, @PathVariable("id") long id){
        return paymentService.updatePayment(id,payment);
    }

    @PostMapping("/addPayment")
    @ResponseStatus(HttpStatus.CREATED)
    public Payment addPayment(@RequestBody Payment payment){
        return paymentService.addPayment(payment);
    }

    @DeleteMapping("/removePayment/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Payment removePayment(@PathVariable("id") long id){
        return paymentService.removePayment(id);
    }
    @GetMapping("/getPayment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Payment getPayment(@PathVariable("id") long id){return  paymentService.getPayment(id);}

    @GetMapping("/getCreditCardPayments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Payment> getCreditCardPayments(@PathVariable("id") long id){
        return paymentService.getCreditCardPayments(id);
    }
    
}
