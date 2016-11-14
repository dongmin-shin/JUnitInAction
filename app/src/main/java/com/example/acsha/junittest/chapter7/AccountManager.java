package com.example.acsha.junittest.chapter7;

/**
 * @author dong.min.shin on 2016. 11. 11..
 */

public interface AccountManager {

	Account findAccountForUser(String userId);

	void updateAccount(Account account);
}
