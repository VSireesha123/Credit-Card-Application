package com.crecard.service;

import com.crecard.execption.CustomException;
import com.crecard.interfaces.ICreditCardService;
import com.crecard.model.CreditCard;
import com.crecard.repository.ICreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService implements ICreditCardService {
    @Autowired
    ICreditCardRepository creditCardRepository;


    @Override
    public CreditCard addCreditCard(CreditCard card) {
        return creditCardRepository.save(card);
    }

    @Override
    public CreditCard removeCreditCard(long cardId) {
        CreditCard card =  getCreditCard(cardId);
        creditCardRepository.deleteCreditCardById(cardId);
        return card;
    }

    @Override
    public CreditCard updateCreditCard(long cardId, CreditCard card) {
        return creditCardRepository.save(card);
    }

    @Override
    public CreditCard getCreditCard(long cardId) {
        Optional<CreditCard> card = creditCardRepository.findById(cardId);
        return card.orElseThrow(()-> new CustomException("CreditCard Not Exists with id :"+cardId));
    }

    @Override
    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    @Override
    public List<CreditCard> getCustomerCreditCards(long id) {
        return creditCardRepository.findCreditCardsByCustomerId(id);
    }


}
