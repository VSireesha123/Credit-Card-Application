package com.crecard.repository;

import com.crecard.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ICreditCardRepository extends JpaRepository<CreditCard,Long> {
    void deleteCreditCardById(long id);

    List<CreditCard> findCreditCardsByCustomerId(long id);
}
