package com.chauhan.in.bankingapp.entity;


import jakarta.persistence.*;

@Entity
@Table(name="account")
public class Account {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="account_holder_name")
    private String accountHolderName;
    private double balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Account(Long id, double balance, String accountHolderName) {
        this.id = id;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
    }

    public Account() {

    }
}
