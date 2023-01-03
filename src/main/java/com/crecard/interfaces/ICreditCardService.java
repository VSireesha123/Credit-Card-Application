package com.crecard.interfaces;

import com.crecard.model.CreditCard;

import java.util.List;

public interface ICreditCardService {
    public CreditCard addCreditCard(CreditCard card);
    public CreditCard removeCreditCard(long cardId);
    public CreditCard updateCreditCard(long cardId,CreditCard card);
    public  CreditCard getCreditCard(long cardId);
    public List<CreditCard> getAllCreditCards();

    public List<CreditCard> getCustomerCreditCards(long id);
}
