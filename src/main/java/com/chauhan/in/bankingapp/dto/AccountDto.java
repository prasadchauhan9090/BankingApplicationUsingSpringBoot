package com.chauhan.in.bankingapp.dto;
//
//import lombok.Data;
//
//@Data
//public class AccountDto {
//
//    private Long id;
//    private String accountHolderName;
//    private double balance;
//
//    public AccountDto(Long id, String accountHolderName, double balance) {
//        this.id = id;
//        this.accountHolderName = accountHolderName;
//        this.balance = balance;
//    }
//
//    public AccountDto() {
//
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public double getBalance() {
//        return balance;
//    }
//
//    public void setBalance(double balance) {
//        this.balance = balance;
//    }
//
//    public String getAccountHolderName() {
//        return accountHolderName;
//    }
//
//    public void setAccountHolderName(String accountHolderName) {
//        this.accountHolderName = accountHolderName;
//    }
//
//
//
//}

public record AccountDto(Long id,
                         String accountHolderName,
                         double balance){

}