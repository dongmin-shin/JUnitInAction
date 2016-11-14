package com.example.acsha.junittest.chapter3;

/**
 * @author dong.min.shin on 2016. 11. 3..
 */

public class ErrorResponse implements Response {

	private Request originalRequest;
	private Exception originalException;

	public ErrorResponse(Request request, Exception exception) {
		this.originalRequest = request;
		this.originalException = exception;
	}

	public Exception getOriginalException() {
		return originalException;
	}

	public Request getOriginalRequest() {
		return originalRequest;
	}

	@Override
	public String getName() {
		return "ErrorResponse";
	}
}
