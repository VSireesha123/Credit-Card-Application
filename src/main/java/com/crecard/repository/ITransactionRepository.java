package com.crecard.repository;

import com.crecard.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ITransactionRepository extends JpaRepository<Transaction,Long> {
    void deleteByTranId(long id);
}
