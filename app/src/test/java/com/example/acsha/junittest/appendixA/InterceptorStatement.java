package com.example.acsha.junittest.appendixA;

import java.util.ArrayList;
import java.util.List;

import org.junit.runners.model.Statement;

/**
 * @author dong.min.shin on 2016. 11. 15..
 */

public class InterceptorStatement extends Statement {

	private final Statement invoker;
	private List<Interceptor> interceptors = new ArrayList<>();

	public InterceptorStatement(Statement invoker) {
		this.invoker = invoker;
	}

	@Override
	public void evaluate() throws Throwable {
		// Intercept before
		for (Interceptor interceptor : interceptors) {
			interceptor.interceptBefore();
		}

		// Original Logic
		invoker.evaluate();

		// Intercept after
		for (Interceptor interceptor : interceptors) {
			interceptor.interceptAfter();
		}
	}

	public void addInterceptor(Interceptor interceptor) {
		interceptors.add(interceptor);
	}
}
