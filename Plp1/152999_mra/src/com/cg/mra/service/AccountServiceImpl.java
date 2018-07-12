package com.cg.mra.service;



import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.exception.RechargeException;

public class AccountServiceImpl implements AccountService {

	AccountDao accountDao = new AccountDaoImpl();

	@Override
	public Account getAccountDetails(String mobileNo) throws RechargeException {
		// TODO Auto-generated method stub

		Account account = accountDao.getAccountDetails(mobileNo);
		if (account == null) {
			throw new RechargeException("Given Account id Does Not Exist");
		}
		return account;
	}

	

	@Override
	
	public int rechargeAccount(String mobileNo, double rechargeAmount) throws RechargeException{
		// TODO Auto-generated method stub
		
		return accountDao.rechargeAccount(mobileNo, rechargeAmount);

	}

	public boolean validateTotal(String mobile, double amount)
			throws RechargeException {
		if (validateAmount(amount) && validateMobileNo(mobile)) {
			return true;
		}
		return false;
	}

	private boolean validateMobileNo(String mobileNo) throws RechargeException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new RechargeException(
					"Mobile Number must be exactly 10 digits long");

		}
		return true;

	}

	private boolean validateAmount(double amount) throws RechargeException {
		if (amount < 0.0) {
			throw new RechargeException(
					"Recharge amount can't be less than 0.0");
		}
		return true;
	}
	
		


}
	
	
	

