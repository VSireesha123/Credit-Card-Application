package com.crecard.controller;

import com.crecard.model.Address;
import com.crecard.model.CreditCard;
import com.crecard.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit_card")
public class CreditCardsController {
    @Autowired
    CreditCardService creditCardService;

    @GetMapping("getAllCreditCards")
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCard> getAllCreditCards(){
        return creditCardService.getAllCreditCards();
    }

    @PutMapping("/updateCreditCard/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CreditCard  updateCreditCard(@RequestBody CreditCard creditCard, @PathVariable("id") long id){
        return creditCardService.updateCreditCard(id,creditCard);
    }

    @PostMapping("/addCreditCard")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard addCreditCard(@RequestBody CreditCard creditCard){
        return creditCardService.addCreditCard(creditCard);
    }

    @DeleteMapping("/removeCreditCard/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CreditCard removeCreditCard(@PathVariable("id") long id){
        return creditCardService.removeCreditCard(id);
    }

    @GetMapping("/getCreditCard/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CreditCard getCreditCard(@PathVariable("id") long id){return  creditCardService.getCreditCard(id);}

    @GetMapping("/getCustomerCreditCards/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCard> getCustomerCreditCards(@PathVariable("id") long id){
        return  creditCardService.getCustomerCreditCards(id);
    }

}
