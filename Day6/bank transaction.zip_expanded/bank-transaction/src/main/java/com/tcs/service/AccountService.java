package com.tcs.service;

import com.tcs.beans.Account;
import com.tcs.exceptions.AccountNotFoundExpection;
import com.tcs.exceptions.InsufficientBalanceException;

public interface AccountService {
	public Account store(Account account);
	public Account fetchAccountByAccountnumber(int accountNumber) throws AccountNotFoundExpection;
	public Account updateAccountPassword(int accountNumber, String password) throws AccountNotFoundExpection;
	public void transferBalance(int sourceAccount, int targetAccount, double amount) throws InsufficientBalanceException, AccountNotFoundExpection;

}
