package com.example.acsha.junittest.chapter3;

/**
 * @author dong.min.shin on 2016. 11. 3..
 */

public interface Controller {

	Response processRequest(Request request);

	void addHandler(Request request, RequestHandler requestHandler);

}
