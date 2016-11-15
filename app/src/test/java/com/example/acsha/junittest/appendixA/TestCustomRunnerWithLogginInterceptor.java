package com.example.acsha.junittest.appendixA;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author dong.min.shin on 2016. 11. 15..
 */
@RunWith(InterceptorRunner.class)
@InterceptorRunner.InterceptorClasses(value = {SampleLoggingInterceptor.class})
public class TestCustomRunnerWithLogginInterceptor {

	@Before
	public void setUp() {
		System.out.println("Real before");
	}

	@After
	public void tearDown() {
		System.out.println("Real after");
	}

	@Test
	public void testDummy() {
		assertTrue(true);
		System.out.println("Some text for test purpose");
	}

}
