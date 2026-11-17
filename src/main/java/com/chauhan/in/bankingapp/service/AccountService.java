package com.chauhan.in.bankingapp.service;

import com.chauhan.in.bankingapp.dto.AccountDto;
import org.springframework.stereotype.Service;


@Service
public interface AccountService {


    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);


}
