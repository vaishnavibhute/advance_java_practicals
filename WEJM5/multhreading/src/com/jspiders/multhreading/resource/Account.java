package com.jspiders.multhreading.resource;

public class Account {
	int accountBalance;

	public Account(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public void checkBalance() {
		System.out.println("Current Balance="+accountBalance);
	}
	
	public synchronized void depositeAmount(int amount) {
		System.out.println("Deposited "+accountBalance +"rs amount");
		accountBalance+=amount;
		checkBalance();
	}
	
	public synchronized void withdrawAmount(int amount) {
		System.out.println("Try to withdraw "+amount +" from the account");
		if(amount>accountBalance) {
			System.out.println("Insufficient Balance");
		}
		else {
			accountBalance-=amount;
			checkBalance();
		}
	}
}
