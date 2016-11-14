package com.example.acsha.junittest.chapter7;

/**
 * @author dong.min.shin on 2016. 11. 11..
 */

public class AccountService {

	private AccountManager accountManager;

	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

	public void transfer(String senderId, String beneficiaryId, long amount) {
		Account sender = accountManager.findAccountForUser(senderId);
		Account beneficiary = accountManager.findAccountForUser(beneficiaryId);

		sender.debit(amount);
		beneficiary.credit(amount);

		accountManager.updateAccount(sender);
		accountManager.updateAccount(beneficiary);
	}
}
