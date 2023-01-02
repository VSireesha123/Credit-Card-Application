package com.crecard.service;

import com.crecard.interfaces.ITransactionService;
import com.crecard.model.Transaction;
import com.crecard.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction removeTransaction(long id) {
        return transactionRepository.deleteByTranId(id);
    }

    @Override
    public Transaction updateTransaction(long id, Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionDetails(long id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return  transaction.orElse(null);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
