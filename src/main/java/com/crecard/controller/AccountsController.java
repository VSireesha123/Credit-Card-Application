package com.crecard.controller;

import com.crecard.model.Account;
import com.crecard.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/accounts")
public class AccountsController {

    @Autowired
    AccountService accountService;

    @GetMapping
    public List<Account> index(){
        return accountService.getAllAccounts();
    }

    @PutMapping("/{id}")
    public Account  update(@RequestBody Account account,@PathVariable("id") long id){
        return accountService.updateAccount(id,account);
    }

    @PostMapping
    public Account create(@RequestBody Account account){
        return accountService.addAccount(account);
    }

    @DeleteMapping("/{id}")
    public Account delete(@PathVariable("id") long id){
        return accountService.removeAccount(id);
    }

    @GetMapping("/{id}")
    public Account show(@PathVariable("id") long id){return  accountService.getAccount(id);}


}
