package com.tcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.beans.Account;
import com.tcs.dao.AccountRepository;
import com.tcs.exceptions.*;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository dao;
	
	@Override
	@Transactional
	public Account store(Account account) {
		return dao.save(account);
	}

	@Override
	public Account fetchAccountByAccountnumber(int accountNumber) throws AccountNotFoundExpection {
		Account a = dao.findById(accountNumber).orElse(null);
		if(a==null)
			throw new AccountNotFoundExpection("Account No. "+accountNumber+" does not exist");
		
		return a;
	}

	@Override
	@Transactional
	public Account updateAccountPassword(int accountNumber, String password) throws AccountNotFoundExpection {
		Account a = fetchAccountByAccountnumber(accountNumber);
		a.setPassword(password);
		return a;
	}
	
	
	@Override
	@Transactional
	public void transferBalance(int sourceAccount, int targetAccount, double amount) throws InsufficientBalanceException, AccountNotFoundExpection {
		
		Account a1 = fetchAccountByAccountnumber(sourceAccount);
		Account a2 = fetchAccountByAccountnumber(targetAccount);
		double balance1 = a1.getBalance();
		if(balance1<amount)
			throw new InsufficientBalanceException("Account No. "+sourceAccount+" has not sufficient balance");
		double balance2 = a2.getBalance();
		a1.setBalance(balance1 - amount);
		a2.setBalance(balance2 + amount);
	}

	
}
