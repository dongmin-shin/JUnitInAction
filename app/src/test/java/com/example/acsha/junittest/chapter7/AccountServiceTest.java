package com.example.acsha.junittest.chapter7;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.acsha.junittest.chapter7.mock.MockAccountManager;

/**
 * @author dong.min.shin on 2016. 11. 11..
 */
public class AccountServiceTest {

	@Test
	public void testTransferOk() {
		// given
		MockAccountManager mockAccountManager = new MockAccountManager();

		Account senderAccount = new Account("1", 200);
		Account beneficiaryAccount = new Account("2", 100);

		mockAccountManager.addAccount("1", senderAccount);
		mockAccountManager.addAccount("2", beneficiaryAccount);

		AccountService accountService = new AccountService();
		accountService.setAccountManager(mockAccountManager);

		accountService.transfer("1", "2", 50);

		assertEquals(150, senderAccount.getBalance());
		assertEquals(150, beneficiaryAccount.getBalance());
	}

}