package com.cg.mra.dao;

import java.util.HashMap;

import com.cg.mra.accountDb.AccountDb;
import com.cg.mra.beans.Account;
import com.cg.mra.exception.RechargeException;
/**
 * Author Name: Srija B
 * Employee Id: 152999
 * 
 * Class Name: AccountDao
 * Number of Methods: 2:
 * 	1. get account details of the entered mobile number
 * 	2. calculate and update the account balance
 * Purpose: Data Access Object method is created to access the Account Object and make changes to it.
 * 
 * The layered architecture is as follows:
 * MainUI->AccountService->AccountDao->AccountDb->Account Object Class
 * 
 * Date of Creation: 11-July-2018
 * Last Modified on 11-July-2018
 * 
 * 
 * @author srijab
 *
 */
public class AccountDaoImpl implements AccountDao {

	HashMap<String, Account> accountMap= AccountDb.getAccountDb();
	
	/**
	 * The below method fetches the accountDetails after validation from the service methods.
	 * Returns an account object after fetching details from accountMap
	 */
	@Override
	public Account getAccountDetails(String mobileNo) throws RechargeException {
		// TODO Auto-generated method stub
		Account account= accountMap.get(mobileNo);
		
		
		return account;
	}

	/** 
	 *
	 *RechargeAccount accepts mobile number and rechargeAmount after being validated in the service layer.
	 *The rechargeAmount is added to the final balance and returned as an integer
	 *
	 */
	@Override
	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		// TODO Auto-generated method stub
		
		
		Account account=accountMap.get(mobileNo);
		double bal= rechargeAmount+account.getAccountBalance();
		account.setAccountBalance(bal);
		return (int) bal;
	}

}
