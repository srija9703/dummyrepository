package com.cg.mra.accountDb;

import java.util.HashMap;



import com.cg.mra.beans.Account;

public class AccountDb {

	static HashMap<String, Account> accountMap = new HashMap<String, Account>();

	public static HashMap<String, Account> getAccountDb() {
		return accountMap;
	}

	static {

		accountMap.put("8106532696", new Account("8106532696", "Post-paid",
				"Shyam", 234.56));

		accountMap.put("1234567890", new Account("1234567890", "Pre-paid",
				"Divya", 300.90));
		accountMap.put("7277256345", new Account("7277256345", "Pre-paid",
				"Mohan", 12.00));

		accountMap.put("7865341230", new Account("7865341230", "Pre-paid",
				"Sakshi", 20.56));
	}

}
