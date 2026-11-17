package com.chauhan.in.bankingapp.service.impl;

import com.chauhan.in.bankingapp.dto.AccountDto;
import com.chauhan.in.bankingapp.entity.Account;
import com.chauhan.in.bankingapp.mapper.AccountMapper;
import com.chauhan.in.bankingapp.repository.AccountRepository;
import com.chauhan.in.bankingapp.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
       Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }
}
