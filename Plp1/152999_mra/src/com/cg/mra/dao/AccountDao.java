package com.cg.mra.dao;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.RechargeException;

public interface AccountDao {

	Account getAccountDetails(String mobileNo) throws RechargeException;

	int rechargeAccount(String mobileNo, double rechargeAmount);

}
