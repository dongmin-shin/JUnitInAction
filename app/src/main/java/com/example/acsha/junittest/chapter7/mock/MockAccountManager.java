package com.example.acsha.junittest.chapter7.mock;

import java.util.HashMap;
import java.util.Map;

import com.example.acsha.junittest.chapter7.Account;
import com.example.acsha.junittest.chapter7.AccountManager;

/**
 * @author dong.min.shin on 2016. 11. 11..
 */

public class MockAccountManager implements AccountManager {

	private Map<String, Account> accounts = new HashMap<>();

	public void addAccount(String userId, Account account) {
		accounts.put(userId, account);
	}

	@Override
	public Account findAccountForUser(String userId) {
		return accounts.get(userId);
	}

	@Override
	public void updateAccount(Account account) {

	}
}
