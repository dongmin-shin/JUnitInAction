package com.example.acsha.junittest.chapter7.webclient;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author dong.min.shin on 2016. 11. 14..
 */

public class WebClient1 {

	public String getContent(URL url) {
		StringBuffer content = new StringBuffer();
		try {
			HttpURLConnection connection = createHttpUrlConnection(url);
			connection.setDoInput(true);
			InputStream inputStream = connection.getInputStream();
			int count;
			while (-1 != (count = inputStream.read())) {
				content.append(new String(Character.toChars(count)));
			}

		} catch (IOException e) {
			return null;
		}

		return content.toString();
	}

	protected HttpURLConnection createHttpUrlConnection(URL url) throws IOException {
		return (HttpURLConnection)url.openConnection();
	}

}
