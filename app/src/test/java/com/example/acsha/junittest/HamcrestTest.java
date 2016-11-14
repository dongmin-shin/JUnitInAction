package com.example.acsha.junittest;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author dong.min.shin on 2016. 11. 3..
 */

public class HamcrestTest {

	private List<String> values;

	@Before
	public void setUpList() {
		values = new ArrayList<>();
		values.add("x");
		values.add("y");
		values.add("z");
	}

	@Test
	public void testWithoutHamcrest() {
		assertFalse(values.contains("one") || values.contains("two") || values.contains("three"));
	}

	@Test
	public void testWithHamcrest() {
		assertThat(values, not(hasItem(anyOf(equalTo("one"), equalTo("two"), equalTo("three")))));
	}

}
