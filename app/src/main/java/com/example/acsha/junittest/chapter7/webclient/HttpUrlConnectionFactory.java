package com.example.acsha.junittest.chapter7.webclient;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author dong.min.shin on 2016. 11. 14..
 */

public class HttpUrlConnectionFactory implements ConnectionFactory {

	private URL url;

	public HttpUrlConnectionFactory(URL url) {
		this.url = url;
	}

	@Override
	public InputStream getData() throws Exception {
		HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
		return httpURLConnection.getInputStream();
	}
}
