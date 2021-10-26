package com.tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tcs.beans.Account;
import com.tcs.beans.CustomResponse;
import com.tcs.exceptions.*;
import com.tcs.service.AccountService;

@RestController
@RequestMapping("account")
public class AccountRest {
	
	@Autowired
	private AccountService service;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveAccount(@RequestBody Account account){
		ResponseEntity<Object> response = ResponseEntity.status(HttpStatus.CREATED).body(service.store(account));
		return response;
	}
	
	@GetMapping(path = "{accountnumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findAccount(@PathVariable("accountnumber") int accountNumber){
		ResponseEntity<Object> response = null;
		try {
			Account account = service.fetchAccountByAccountnumber(accountNumber);
			response = ResponseEntity.status(HttpStatus.OK).body(account);
		}catch(AccountNotFoundExpection e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		return response;
	}
	
	@PutMapping(path = "{accountnumber}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateAccountPassword(@PathVariable("accountnumber") int accountnumber, @PathVariable("password") String password){
		ResponseEntity<Object> response = null;
		try {
			Account account = service.updateAccountPassword(accountnumber,password);
			response = ResponseEntity.status(HttpStatus.OK).body(account);
		}catch(AccountNotFoundExpection e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		return response;
	}
	
	@PutMapping(path = "{sourceaccount}/{targetaccount}/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateAccountBalance(@PathVariable("sourceaccount") int sourceaccount, @PathVariable("targetaccount") int targetaccount, @PathVariable("amount") double amount){
		ResponseEntity<Object> response = null;
		try {
			service.transferBalance(sourceaccount,targetaccount,amount);
			CustomResponse data = new CustomResponse();
			data.setMsg("Money Transaction Successfull");
			response = ResponseEntity.status(HttpStatus.OK).body(data);
		}catch(AccountNotFoundExpection e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}catch(InsufficientBalanceException i) {
			CustomResponse data = new CustomResponse();
			data.setMsg(i.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		return response;
	}
}
