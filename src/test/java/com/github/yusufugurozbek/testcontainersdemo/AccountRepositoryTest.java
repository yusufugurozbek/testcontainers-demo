package com.github.yusufugurozbek.testcontainersdemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
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
        Account account = new Account("Test", "Account", new BigDecimal(0), LocalDate.now());
        accountRepository.save(account);

        // when
        List<Account> accounts = accountRepository.findAll();

        // then
        assertEquals("Count is incorrect", 1, accounts.size());
    }

    @Test
    void findAccountsByAgeOlderThan_returnsCorrectCount() {
        // given
        addTestAccounts();

        // when
        var accountsOlderThan = accountRepository.findAccountsByAgeOlderThan(40);

        // then
        assertEquals("Size is incorrect", 2, accountsOlderThan.size());
    }

    @Test
    void getTotalAmount_returnsCorrectAmount() {
        // given
        addTestAccounts();

        // when
        var totalAmount = accountRepository.getTotalAmount();

        // then
        assertEquals("Total amount is incorrect", new BigDecimal(1110000), totalAmount);
    }

    private void addTestAccounts() {
        var accounts = List.of(
                new Account("Yusuf Ugur", "ÖZBEK", new BigDecimal(1000000), LocalDate.now().minusYears(35)),
                new Account("Yusuf", "ÖZBEK", new BigDecimal(100000), LocalDate.now().minusYears(45)),
                new Account("Ugur", "ÖZBEK", new BigDecimal(10000), LocalDate.now().minusYears(55))
        );
        accountRepository.saveAll(accounts);
    }

}
