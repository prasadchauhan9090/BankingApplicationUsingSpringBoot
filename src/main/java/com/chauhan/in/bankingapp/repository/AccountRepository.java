package com.chauhan.in.bankingapp.repository;

import com.chauhan.in.bankingapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {


}
