package com.github.yusufugurozbek.testcontainersdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account")
    List<Account> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/account/{accountId}/age")
    int getAge(@PathVariable long accountId) {
        return accountService.getAge(accountId);
    }

    @GetMapping("/account/total-amount")
    BigDecimal getTotalAmount() {
        return accountService.getTotalAmount();
    }

}
