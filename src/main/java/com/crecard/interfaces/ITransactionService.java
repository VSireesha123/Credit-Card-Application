package com.crecard.interfaces;

import com.crecard.model.Transaction;

import java.util.List;

public interface ITransactionService {
    public Transaction addTransaction(Transaction transaction);
    public Transaction removeTransaction(long id);
    public Transaction updateTransaction(long id, Transaction transaction);
    public Transaction getTransactionDetails(long id);
    public List<Transaction> getAllTransactions();
}
