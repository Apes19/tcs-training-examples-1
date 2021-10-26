package com.tcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.beans.Account;


public interface AccountRepository extends JpaRepository<Account, Integer>{
}
