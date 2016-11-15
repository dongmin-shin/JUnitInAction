package com.example.acsha.junittest.appendixB;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * @author dong.min.shin on 2016. 11. 15..
 */

public class IsStrongPassword extends TypeSafeMatcher<String> {

	@Override
	protected boolean matchesSafely(String item) {
		return containsDigit(item) && containsSpecialSymbol(item) && isGreatestEqualThanMinSize(item);
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("string that contains a digit, a special character and is at least 6 symbols");
	}

	private boolean isGreatestEqualThanMinSize(String str) {
		return str.length() >= 6;
	}

	private boolean containsDigit(String str) {
		for (char ch : str.toCharArray()) {
			if (Character.isDigit(ch)) {
				return true;
			}
		}

		return false;
	}

	private boolean containsSpecialSymbol(String str) {
		for (char ch : str.toCharArray()) {
			if (((int)ch <= 47) && ((int)ch) >= 33) {
				return true;
			}
		}

		return false;
	}

	@Factory
	public static <T> Matcher<String> isStrongPassword() {
		return new IsStrongPassword();
	}

	@Factory
	public static <T> Matcher<String> strongPassword() {
		return new IsStrongPassword();
	}
}
