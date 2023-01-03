package com.crecard.controller;

import com.crecard.model.Address;
import com.crecard.model.Transaction;
import com.crecard.model.Transaction;
import com.crecard.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {
    @Autowired
    TransactionService transactionService;

    @GetMapping("/getAllTransactions")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> getAllTransactions(){
        return transactionService.getAllTransactions();
    }

    @PutMapping("/updateTransaction/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Transaction  updateTransaction(@RequestBody Transaction transaction, @PathVariable("id") long id){
        return transactionService.updateTransaction(id,transaction);
    }

    @PostMapping("/addTransaction")
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction addTransaction(@RequestBody Transaction transaction){
        return transactionService.addTransaction(transaction);
    }

    @DeleteMapping("/removeTransaction/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Transaction removeTransaction(@PathVariable("id") long id){
        return transactionService.removeTransaction(id);
    }

    @GetMapping("/getTransactionDetails/{id}")
    public Transaction show(@PathVariable("id") long id){return  transactionService.getTransactionDetails(id);}

}