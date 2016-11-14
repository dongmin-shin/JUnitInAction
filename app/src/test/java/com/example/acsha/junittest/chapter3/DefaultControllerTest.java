package com.example.acsha.junittest.chapter3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author dong.min.shin on 2016. 11. 3..
 */
public class DefaultControllerTest {

	private DefaultController controller;
	private Request request;
	private RequestHandler requestHandler;

	@Before
	public void initialize() throws Exception {
		controller = new DefaultController();
		request = new SampleRequest();
		requestHandler = new SampleHandler();
		controller.addHandler(request, requestHandler);
	}

	@Test
	public void testAddHandler() {
		// then
		RequestHandler resultRequestHandler = controller.getHandler(request);
		assertSame("Handler we set in controller should be the same handler we get", resultRequestHandler,
			requestHandler);
	}

	@Test
	public void testProcessRequest() {
		// when
		Response response = controller.processRequest(request);

		// then
		assertNotNull("Must not return a null response", response);
		assertEquals("Response should be of type SampleResponse", new SampleResponse(), response);
	}

	@Test
	public void testProcessRequestAnswersErrorResponse() {
		SampleRequest sampleRequest = new SampleRequest("testError");
		SampleExceptionHandler handler = new SampleExceptionHandler();
		controller.addHandler(sampleRequest, handler);
		Response response = controller.processRequest(sampleRequest);
		assertNotNull("Must not return a null response", response);
		assertEquals(ErrorResponse.class, response.getClass());
	}

	@Test(expected = RuntimeException.class)
	public void testGetHandlerNotDefined() {
		SampleRequest sampleRequest = new SampleRequest("testNotDefined");

		// 다음 줄에서 RuntimeException을 발생시킬 것이다.
		controller.getHandler(sampleRequest);
	}

	@Test(expected = RuntimeException.class)
	public void testAddRequestDuplicateName() {
		SampleRequest request = new SampleRequest();
		SampleHandler handler = new SampleHandler();

		// 다음 줄에서 RuntimeException을 발생시킬 것이다.
		controller.addHandler(request, handler);
	}

	@Test(timeout = 130)
	@Ignore(value = "Ignore for now until we decide a decent time-limit")
	public void testProcessMultipleRequestsTimeout() {
		RequestHandler handler = new SampleHandler();
		for (int i = 0; i < 99999; i++) {
			Request request = new SampleRequest(String.valueOf(i));
			controller.addHandler(request, handler);
			Response response = controller.processRequest(request);

			assertNotNull(response);
			assertNotSame(ErrorResponse.class, response.getClass());
		}
	}

	private class SampleRequest implements Request {

		public static final String DEFAULT_NAME = "Test";
		private String name;

		public SampleRequest(String name) {
			this.name = name;
		}

		public SampleRequest() {
			this(DEFAULT_NAME);
		}

		@Override
		public String getName() {
			return name;
		}
	}

	private class SampleHandler implements RequestHandler {

		@Override
		public Response process(Request request) throws Exception {
			return new SampleResponse();
		}
	}

	private class SampleResponse implements Response {
		private static final String NAME = "Test";

		@Override
		public String getName() {
			return NAME;
		}

		@Override
		public boolean equals(Object obj) {
			boolean result = false;
			if (obj instanceof SampleResponse) {
				result = ((SampleResponse)obj).getName().equals(getName());
			}

			return result;
		}

		@Override
		public int hashCode() {
			return NAME.hashCode();
		}
	}

	private class SampleExceptionHandler implements RequestHandler {

		@Override
		public Response process(Request request) throws Exception {
			throw new Exception("error processing request");
		}
	}

}