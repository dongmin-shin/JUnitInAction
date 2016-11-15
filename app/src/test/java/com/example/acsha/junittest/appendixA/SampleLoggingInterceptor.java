package com.example.acsha.junittest.appendixA;

/**
 * @author dong.min.shin on 2016. 11. 15..
 */

public class SampleLoggingInterceptor implements Interceptor {

	@Override
	public void interceptBefore() {
		System.out.println("Before-test");
	}

	@Override
	public void interceptAfter() {
		System.out.println("After-test");
	}
}
