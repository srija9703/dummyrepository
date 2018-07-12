package com.cg.mra.service.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import com.cg.mra.exception.RechargeException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class RechargeAccountTest {
	AccountService accountService;
	@Before
	public void setUp() throws Exception {
		
		accountService=new AccountServiceImpl();
	}

	@Test
	public void test() throws RechargeException {
		assertNotEquals(1,accountService.rechargeAccount("8106532696", 220.00));
	}
	@Test
	public void test1() throws RechargeException {
		assertNotEquals(2,accountService.rechargeAccount("8106532696", 220.00));
	}

}
