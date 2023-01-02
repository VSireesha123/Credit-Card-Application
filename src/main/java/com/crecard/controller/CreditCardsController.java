package com.crecard.controller;

import com.crecard.model.Address;
import com.crecard.model.CreditCard;
import com.crecard.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit_card")
public class CreditCardsController {
    @Autowired
    CreditCardService creditCardService;

    @GetMapping
    public List<CreditCard> index(){
        return creditCardService.getAllCreditCards();
    }

    @PutMapping("/{id}")
    public CreditCard  update(@RequestBody CreditCard creditCard, @PathVariable("id") long id){
        return creditCardService.updateCreditCard(id,creditCard);
    }

    @PostMapping
    public CreditCard create(@RequestBody CreditCard creditCard){
        return creditCardService.addCreditCard(creditCard);
    }

    @DeleteMapping("/{id}")
    public CreditCard delete(@PathVariable("id") long id){
        return creditCardService.removeCreditCard(id);
    }

    @GetMapping("/{id}")
    public CreditCard show(@PathVariable("id") long id){return  creditCardService.getCreditCard(id);}

    @GetMapping("/customer/{id}")
    public List<CreditCard> getCustomerCreditCards(@PathVariable("id") long id){
        return  creditCardService.getCustomerCreditCards(id);
    }

}
