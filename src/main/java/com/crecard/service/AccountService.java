package com.crecard.service;

import com.crecard.interfaces.IAccountService;
import com.crecard.model.Account;
import com.crecard.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account removeAccount(long id) {
        Account account = accountRepository.findByAccountId(id);
        accountRepository.deleteAccountByAccountId(id);
        return account;
    }

    @Override
    public Account updateAccount(long id, Account account) {
        Account account1 = getAccount(id);
        account1.setAccountType(account.getAccountType());
        account1.setBalance(account.getBalance());
        account1.setAccountName(account.getAccountName());
        return accountRepository.save(account);
    }

    @Override
    public Account getAccount(long id) {
        Optional<Account> account = accountRepository.findById(id);
        return  account.orElse(null);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

}
