package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.RechargeException;

public interface AccountService {

	Account getAccountDetails(String mobileNo) throws RechargeException;
	int rechargeAccount(String mobileno, double rechargeAmount) throws RechargeException;
	
	
}
