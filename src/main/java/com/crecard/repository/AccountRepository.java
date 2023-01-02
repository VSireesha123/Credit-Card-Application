package com.crecard.repository;

import com.crecard.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account,Long> {
    List<Account> findAll();
    Account findByAccountId(long id);
    void deleteAccountByAccountId(long id);

}
