package com.chauhan.in.bankingapp.service.impl;

import com.chauhan.in.bankingapp.dto.AccountDto;
import com.chauhan.in.bankingapp.entity.Account;
import com.chauhan.in.bankingapp.exception.AccountException;
import com.chauhan.in.bankingapp.mapper.AccountMapper;
import com.chauhan.in.bankingapp.repository.AccountRepository;
import com.chauhan.in.bankingapp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public AccountDto getAccountById(Long id) {

       Account account = accountRepository
               .findById(id)
               .orElseThrow(()->new AccountException("ACCOUNT DOES NOT EXISTS"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new AccountException("ACCOUNT DOES NOT EXISTS"));


        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account saveAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new AccountException("ACCOUNT DOES NOT EXISTS"));

        if(account.getBalance() < amount) {

            throw new RuntimeException("Insuffient amount");

        }

        double total = account.getBalance() - amount;
        account.setBalance(total);
       Account saveAccount = accountRepository.save(account);

       return AccountMapper.mapToAccountDto(saveAccount);

    }

    @Override
    public List<AccountDto> getAllAccounts() {

        List<Account> accounts = accountRepository.findAll();

       return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());


    }

    @Override
    public void deleteAccount(Long id) {



        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new AccountException("ACCOUNT DOES NOT EXISTS"));


        accountRepository.deleteById(id);

    }
}
