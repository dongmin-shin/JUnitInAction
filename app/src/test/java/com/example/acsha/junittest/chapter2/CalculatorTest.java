package com.example.acsha.junittest.chapter2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.acsha.junittest.chapter2.Calculator;

/**
 * @author dong.min.shin on 2016. 11. 2..
 */
public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator calculator = new Calculator();
		double result = calculator.add(1, 1);
		assertEquals("Calculator add failed", 2, result, 0);
	}

}