package com.crecard.interfaces;

import com.crecard.model.Account;

import java.util.List;

public interface IAccountService {
    public Account addAccount(Account account);
    public Account removeAccount(long id);
    public Account updateAccount(long id, Account account);
    public Account getAccount(long id);
    public List<Account> getAllAccounts();
}
