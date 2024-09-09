package com.tobaki.tobaki.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tobaki.tobaki.WebAppTest;
import com.tobaki.tobaki.dto.Ch13Account;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch16AccountServiceTest extends WebAppTest {

	@Autowired
	private Ch15AccountService accountService;
	
	@Test
	public void transfer() {
		Ch13Account fromAccount = accountService.getAccount(1);
		Ch13Account toAccount = accountService.getAccount(2);
		int fromAccountBalance = fromAccount.getBalance();
		int toAccountBalance = toAccount.getBalance();
		
		accountService.transfer(1, 2, 1000);
		
		Ch13Account afterFromAccount = accountService.getAccount(1);
		Ch13Account afterToAccount = accountService.getAccount(2);
		int afterFromAccountBalance = afterFromAccount.getBalance();
		int afterToAccountBalance = afterToAccount.getBalance();
		
		Assert.assertEquals(fromAccountBalance-1000, afterFromAccountBalance);
		Assert.assertEquals(toAccountBalance+1000, afterToAccountBalance);
		
	}

}
