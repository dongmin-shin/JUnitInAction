package com.example.acsha.junittest.appendixB;

import static com.example.acsha.junittest.appendixB.IsStrongPassword.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author dong.min.shin on 2016. 11. 15..
 */

public class TestIsPasswordStringUsingMatcher {

	@Test
	public void testIsPasswordStringIsStrong() {
		final String password = "!abcde0";

		assertThat(password, isStrongPassword());
		assertThat(password, is(strongPassword()));
	}

	@Test(expected = AssertionError.class)
	public void testIsPasswordStringIsShort() {
		final String password = "abcde";

		assertThat(password, isStrongPassword());
		assertThat(password, is(strongPassword()));
	}

	@Test(expected = AssertionError.class)
	public void testIsPasswordStringContainsNoSpecialCharacter() {
		final String password = "abcdef0";

		assertThat(password, isStrongPassword());
		assertThat(password, is(strongPassword()));
	}

	@Test(expected = AssertionError.class)
	public void testIsPasswordStringContainsNoDigit() {
		final String password = "!abcdef";

		assertThat(password, isStrongPassword());
		assertThat(password, is(strongPassword()));
	}

	@Test(expected = AssertionError.class)
	public void testIsPasswordStringIsNull() {
		final String password = null;

		assertThat(password, isStrongPassword());
		assertThat(password, is(strongPassword()));
	}

}
