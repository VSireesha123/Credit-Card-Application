package com.crecard.controller;

import com.crecard.model.Address;
import com.crecard.model.Transaction;
import com.crecard.model.Transaction;
import com.crecard.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {
    @Autowired
    TransactionService transactionService;

    @GetMapping
    public List<Transaction> index(){
        return transactionService.getAllTransactions();
    }

    @PutMapping("/{id}")
    public Transaction  update(@RequestBody Transaction transaction, @PathVariable("id") long id){
        return transactionService.updateTransaction(id,transaction);
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction transaction){
        return transactionService.addTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public Transaction delete(@PathVariable("id") long id){
        return transactionService.removeTransaction(id);
    }

    @GetMapping("/{id}")
    public Transaction show(@PathVariable("id") long id){return  transactionService.getTransactionDetails(id);}

}