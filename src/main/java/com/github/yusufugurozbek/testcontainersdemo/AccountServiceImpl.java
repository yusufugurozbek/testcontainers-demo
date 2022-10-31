package com.github.yusufugurozbek.testcontainersdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Autowired
    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

    @Override
    public int getAge(long accountId) {
        return repository.getAgeById(accountId);
    }

    @Override
    public BigDecimal getTotalAmount() {
        return repository.getTotalAmount();
    }

}
