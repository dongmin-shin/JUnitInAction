package com.example.acsha.junittest.chapter7.mock;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author dong.min.shin on 2016. 11. 14..
 */

public class MockHttpUrlConnection extends HttpURLConnection {

	private InputStream inputStream;

	public MockHttpUrlConnection() throws MalformedURLException {
		super(null);
	}

	protected MockHttpUrlConnection(URL u) {
		super(u);
	}

	public void setExpectedInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public InputStream getInputStream() {
		return inputStream;
	}

	@Override
	public void disconnect() {

	}

	@Override
	public boolean usingProxy() {
		return false;
	}

	@Override
	public void connect() throws IOException {

	}
}
