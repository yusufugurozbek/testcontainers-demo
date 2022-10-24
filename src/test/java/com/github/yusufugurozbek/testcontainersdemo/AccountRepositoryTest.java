package com.github.yusufugurozbek.testcontainersdemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void count_returnsCorrectCount() {
        assertEquals("DB is not empty", 0L, accountRepository.count());
    }

    @Test
    void findAll_returnsCorrectCount() {
        // given
        var account = new Account("Test", "Account", new BigDecimal(0), LocalDate.now());
        accountRepository.save(account);

        // when
        var accounts = accountRepository.findAll();

        // then
        assertEquals("Count is incorrect", 1, accounts.size());
    }

}
