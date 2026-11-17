package com.chauhan.in.bankingapp.controller;

import com.chauhan.in.bankingapp.dto.AccountDto;
import com.chauhan.in.bankingapp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/accounts")
public class AccountController {


    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    //Add account REST API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }



}
