package com.example.acsha.junittest.appendixB;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/**
 * @author dong.min.shin on 2016. 11. 15..
 */

public class IsNotNullOrEmpty extends BaseMatcher<String> {

	@Override
	public boolean matches(Object string) {
		String str = (String)string;
		return (str != null) && !str.equals("");
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("a string that is not null and not empty");
	}

	@Factory
	public static <T> Matcher<String> isNotNullOrEmpty() {
		return new IsNotNullOrEmpty();
	}

	@Factory
	public static <T> Matcher<String> notNullOrEmpty() {
		return new IsNotNullOrEmpty();
	}

}
