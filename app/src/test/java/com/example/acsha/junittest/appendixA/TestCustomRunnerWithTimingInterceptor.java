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
@InterceptorRunner.InterceptorClasses(SampleTimingInterceptor.class)
public class TestCustomRunnerWithTimingInterceptor {

	@Before
	public void setUp() throws InterruptedException {
		Thread.sleep(1000);
	}

	@Test
	public void testDummy() throws InterruptedException {
		Thread.sleep(2000);
		assertTrue(true);
	}

	@After
	public void longTearDown() throws InterruptedException {
		Thread.sleep(1000);
	}

}
