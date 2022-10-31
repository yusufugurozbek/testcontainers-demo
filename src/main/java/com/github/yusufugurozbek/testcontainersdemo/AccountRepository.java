package com.github.yusufugurozbek.testcontainersdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.math.BigDecimal;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT extract(year from age(birthdate)) FROM account WHERE  id = :accountId", nativeQuery = true)
    int getAgeById(long accountId);

    @Procedure(value = "get_total_amount")
    BigDecimal getTotalAmount();

}
