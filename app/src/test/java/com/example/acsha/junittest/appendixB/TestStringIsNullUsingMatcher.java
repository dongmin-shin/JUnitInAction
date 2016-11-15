package com.example.acsha.junittest.appendixB;

import static com.example.acsha.junittest.appendixB.IsNotNullOrEmpty.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

/**
 * @author dong.min.shin on 2016. 11. 15..
 */

public class TestStringIsNullUsingMatcher {

	@Test(expected = AssertionError.class)
	public void testIsNotNullOrEmptyButIsNull() {
		String str = null;
		assertThat(str, isNotNullOrEmpty());
	}

	@Test(expected = AssertionError.class)
	public void testIsNotNullOrEmptyButIsEmpty() {
		String str = "";

		assertThat(str, isNotNullOrEmpty());
		assertThat(str, is(notNullOrEmpty()));
	}

	@Test
	public void testIsNotNullOrEmptyIsNotNull() {
		String str = "test";

		assertThat(str, isNotNullOrEmpty());
		assertThat(str, is(notNullOrEmpty()));
	}

}
