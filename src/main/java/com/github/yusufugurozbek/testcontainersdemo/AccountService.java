package com.github.yusufugurozbek.testcontainersdemo;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {

    List<Account> findAll();

    int getAge(long accountId);

    BigDecimal getTotalAmount();

}
