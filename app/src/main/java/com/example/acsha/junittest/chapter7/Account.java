package com.example.acsha.junittest.chapter7;

/**
 * @author dong.min.shin on 2016. 11. 11..
 */

public class Account {

	private String accountId;
	private long balance;

	public Account(String accountId, long initialBalance) {
		this.accountId = accountId;
		this.balance = initialBalance;
	}

	public void debit(long amount) {
		this.balance -= amount;
	}

	public void credit(long amout) {
		this.balance += amout;
	}

	public long getBalance() {
		return balance;
	}
}
