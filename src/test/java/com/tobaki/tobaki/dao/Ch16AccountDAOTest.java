package com.tobaki.tobaki.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tobaki.tobaki.WebAppTest;
import com.tobaki.tobaki.dao.mybatis.Ch13AccountDAO;
import com.tobaki.tobaki.dto.Ch13Account;

public class Ch16AccountDAOTest extends WebAppTest {
	@Autowired
	private Ch13AccountDAO accountDAO;
	
	@Test
	public void testSelectAll() {
		List<Ch13Account> list = accountDAO.selectAll();
		Assert.assertNotNull(list);
		Assert.assertEquals(2, list.size());
	}
	
	@Test
	public void testSelectByAno() {
		Ch13Account account = accountDAO.selectByAno(1);
		Assert.assertNotNull(account);
		Assert.assertEquals(1, account.getAno());
		Assert.assertNotNull(account.getOwner());
		Assert.assertNotNull(account.getBalance());
	}
	
	@Test
	public void testUpdate() {
		Ch13Account account = accountDAO.selectByAno(1);
		account.setBalance(account.getBalance() + 1000);
		accountDAO.update(account);
		
		Ch13Account dbAccount = accountDAO.selectByAno(1);
		Assert.assertEquals(account.getBalance(), dbAccount.getBalance());
	}
}
