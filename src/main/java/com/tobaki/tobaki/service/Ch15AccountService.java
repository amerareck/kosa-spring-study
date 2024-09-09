package com.tobaki.tobaki.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tobaki.tobaki.dao.mybatis.Ch13AccountDAO;
import com.tobaki.tobaki.dto.Ch13Account;
import com.tobaki.tobaki.exception.Ch15AccountNotExistException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Ch15AccountService {
	@Autowired
	private Ch13AccountDAO accountDAO;
	
	public List<Ch13Account> getAccountList() {
		List<Ch13Account> list = accountDAO.selectAll();
		return list;
	}
	
	public Ch13Account getAccount(int ano) {
		Ch13Account account = accountDAO.selectByAno(ano);
		return account;
	}
	
	@Transactional
	public void transfer(int fromAno, int toAno, int amount) {
		// 출금 작업
		Ch13Account fromAccount = accountDAO.selectByAno(fromAno);
		if (fromAccount == null) {
			throw new Ch15AccountNotExistException("출금 계좌 없음");
		}
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		accountDAO.update(fromAccount);
		
		// 입금 작업
		Ch13Account toAccount = accountDAO.selectByAno(toAno);
		if (toAccount == null) {
			throw new Ch15AccountNotExistException("입금 계좌 없음");
		}
		toAccount.setBalance(toAccount.getBalance() + amount);
		accountDAO.update(toAccount);
	}

}
