package com.crecard.service;

import com.crecard.interfaces.ICreditCardService;
import com.crecard.model.CreditCard;
import com.crecard.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService implements ICreditCardService {
    @Autowired
    CreditCardRepository creditCardRepository;


    @Override
    public CreditCard addCreditCard(CreditCard card) {
        return creditCardRepository.save(card);
    }

    @Override
    public CreditCard removeCreditCard(long cardId) {
        return creditCardRepository.deleteCreditCardById(cardId);
    }

    @Override
    public CreditCard updateCreditCard(long cardId, CreditCard card) {
        return creditCardRepository.save(card);
    }

    @Override
    public CreditCard getCreditCard(long cardId) {
        Optional<CreditCard> card = creditCardRepository.findById(cardId);
        return card.orElse(null);
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
