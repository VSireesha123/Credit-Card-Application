package com.crecard.service;

import com.crecard.execption.CustomException;
import com.crecard.interfaces.ITransactionService;
import com.crecard.model.Transaction;
import com.crecard.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    ITransactionRepository transactionRepository;
    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction removeTransaction(long id) {
        Transaction transaction=getTransactionDetails(id);
         transactionRepository.deleteByTranId(id);
        return transaction;
    }

    @Override
    public Transaction updateTransaction(long id, Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionDetails(long id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return  transaction.orElseThrow(()-> new CustomException("Transaction Not Exists with id :"+id));
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
