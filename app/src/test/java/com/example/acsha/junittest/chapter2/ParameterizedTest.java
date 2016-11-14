package com.example.acsha.junittest.chapter2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.example.acsha.junittest.chapter2.Calculator;

/**
 * @author dong.min.shin on 2016. 11. 2..
 */

@RunWith(value = Parameterized.class)
public class ParameterizedTest {

	private double expected;
	private double valueOne;
	private double valueTwo;

	public ParameterizedTest(double expected, double valueOne, double valueTwo) {
		this.expected = expected;
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
	}

	@Parameterized.Parameters
	public static Collection<Integer[]> getTestParameters() {
		return (Collection<Integer[]>)Arrays.asList(new Integer[][] {
			{2, 1, 1}, {3, 2, 1}, {4, 3, 1}
		});
	}

	@Test
	public void sum() {
		Calculator calculator = new Calculator();
		assertEquals("Sum failed", expected, calculator.add(valueOne, valueTwo), 0);
	}

}
