package com.example.acsha.junittest.chapter3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dong.min.shin on 2016. 11. 3..
 */

public class DefaultController implements Controller {

	public Map requestHandlers = new HashMap<>();

	protected RequestHandler getHandler(Request request) {
		if (!requestHandlers.containsKey(request.getName())) {
			String message = "Cannot find handler for request name [" + request.getName() + "]";
			throw new RuntimeException(message);
		}

		return (RequestHandler)requestHandlers.get(request.getName());
	}

	@Override
	public Response processRequest(Request request) {
		Response response;
		try {
			response = getHandler(request).process(request);
		} catch (Exception exception) {
			response = new ErrorResponse(request, exception);
		}

		return response;
	}

	@Override
	public void addHandler(Request request, RequestHandler requestHandler) {
		if (requestHandlers.containsKey(request.getName())) {
			throw new RuntimeException(
				"A request handler has already been registered for request name [" + request.getName() + "]");
		}

		requestHandlers.put(request.getName(), requestHandler);
	}
}
