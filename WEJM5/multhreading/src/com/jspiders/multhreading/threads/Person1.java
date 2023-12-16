package com.jspiders.multhreading.threads;

import com.jspiders.multhreading.resource.Account;

public class Person1 extends Thread {
		Account account;
		
		
		public Person1(Account account) {
			this.account = account;
		}


		public void run() {
			account.depositeAmount(3000);
			account.withdrawAmount(5000);
		}
}
