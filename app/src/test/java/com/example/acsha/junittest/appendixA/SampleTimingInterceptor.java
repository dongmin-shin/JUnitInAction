package com.example.acsha.junittest.appendixA;

/**
 * @author dong.min.shin on 2016. 11. 15..
 */

public class SampleTimingInterceptor implements Interceptor {

	private Timer timer = new Timer();

	@Override
	public void interceptBefore() {
		System.out.println("Interceptor started.");
		timer.start();
	}

	@Override
	public void interceptAfter() {
		timer.end();
		System.out.println("Interceptor ended. The test executed for " + timer.time() + " sec");
	}

	private class Timer {
		private long nanoStart = 1;
		private long nanoEnd = 0;

		void start() {
			nanoStart = System.nanoTime();
		}

		void end() {
			nanoEnd = System.nanoTime();
		}

		long time() {
			return (nanoEnd - nanoStart) / (1000000 * 1000);
		}
	}
}
