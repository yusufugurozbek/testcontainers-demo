package com.github.yusufugurozbek.testcontainersdemo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private BigDecimal balance;

    @Column
    private LocalDate birthdate;

    //region Constructors

    public Account() {

    }

    public Account(String firstName, String lastName, BigDecimal balance, LocalDate birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.birthdate = birthdate;
    }

    //endregion

    //region Getters and Setters

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    //endregion

}
