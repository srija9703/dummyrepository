package com.cg.mra.ui;

import java.util.Scanner;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.RechargeException;
import com.cg.mra.service.*;

public class MainUI {
	Scanner sc = new Scanner(System.in);

	AccountServiceImpl service = new AccountServiceImpl();

	public static void main(String[] args) {

		MainUI m = new MainUI();
		System.out.println("========================================");
		System.out.println(" Welcome to Mobile Recharge Application");
		System.out.println("========================================");

		String option = null;
		while (true) {
			System.out.println();
			System.out.println("Services provided are");
			System.out.println("1. Account Balance Enquiry");
			System.out.println("2. Recharge Account");
			System.out.println("3. Exit");
			System.out.println("Enter the service you want");
			option = m.sc.nextLine();

			switch (option) {
			case "1":
				m.accountBalEnquiry();
				break;
			case "2":
				m.rechargeAccount();
				break;

			case "3":
				System.out
						.println("Exited Application successfully. Have a nice day");
				System.exit(0);
			default: {
				System.out.println();
				System.out.println("Invalid Option. Enter 1, 2 or 3");
				System.out.println();
			}

			}

		}

	}

	private void accountBalEnquiry() {
		System.out.println("Enter your registered mobile number");
		String mobile = sc.nextLine();

		Account account = null;
		try {
			account = service.getAccountDetails(mobile);
			System.out.println();
			System.out.println("Your Current balance is: "
					+ account.getAccountBalance());
		} catch (RechargeException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println("ERROR : " + e.getMessage());
			System.out.println();
		}

	}

	private void rechargeAccount() {
		// TODO Auto-generated method stub
		System.out.println("Enter mobile number to be recharged");
		String mobileNo = sc.nextLine();
		System.out.println("Enter recharge amount");
		double amount = Double.parseDouble(sc.next());

		boolean flag = false;
		try {
			flag = service.validateTotal(mobileNo, amount);

		} catch (RechargeException e2) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println("ERROR : " + e2.getMessage());
			System.out.println();
		}
		
		if (flag) {
			try {
				service.rechargeAccount(mobileNo, amount);
				Account account = service.getAccountDetails(mobileNo);
				System.out.println();
				System.out
						.println("Account Recharged Successfully");
				System.out.println("Hello " + account.getCustomerName()
						+ ", Account Balance is: "
						+ account.getAccountBalance());

			} catch (RechargeException e) {
				// TODO Auto-generated catch block
				System.out.println();
				System.err.println("ERROR : " + e.getMessage());
				System.out.println();
			}

		}

	}
}
