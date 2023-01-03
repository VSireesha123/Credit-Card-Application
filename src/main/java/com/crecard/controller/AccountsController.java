package com.crecard.controller;

import com.crecard.model.Account;
import com.crecard.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/accounts")
public class AccountsController {

    @Autowired
    AccountService accountService;

    @GetMapping("/getAllAccounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @PutMapping("/updateAccount/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Account  updateAccount(@RequestBody Account account,@PathVariable("id") long id){
        return accountService.updateAccount(id,account);
    }

    @PostMapping("/addAccount")
    @ResponseStatus(HttpStatus.CREATED)
    public Account addAccount(@RequestBody Account account){
        return accountService.addAccount(account);
    }

    @DeleteMapping("/removeAccount/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Account removeAccount(@PathVariable("id") long id){
        return accountService.removeAccount(id);
    }

    @GetMapping("getAccount/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account getAccount(@PathVariable("id") long id){return  accountService.getAccount(id);}


}
