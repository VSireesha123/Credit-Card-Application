package com.crecard.repository;

import com.crecard.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {
    CreditCard deleteCreditCardById(long id);

    List<CreditCard> findCreditCardsByCustomerId(long id);
}
