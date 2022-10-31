package com.github.yusufugurozbek.testcontainersdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT * FROM account WHERE extract(year from age(birthdate)) > :age", nativeQuery = true)
    List<Account> findAccountsByAgeOlderThan(int age);

    @Procedure(value = "get_total_amount")
    BigDecimal getTotalAmount();

}
