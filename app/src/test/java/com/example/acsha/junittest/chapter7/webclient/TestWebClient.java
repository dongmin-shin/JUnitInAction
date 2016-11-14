package com.example.acsha.junittest.chapter7.webclient;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

import com.example.acsha.junittest.chapter7.mock.MockConnectionFactory;
import com.example.acsha.junittest.chapter7.mock.MockHttpUrlConnection;
import com.example.acsha.junittest.chapter7.mock.MockInputStream;

/**
 * @author dong.min.shin on 2016. 11. 14..
 */

public class TestWebClient {

	@Test
	public void testGetContentOK() throws Exception {

		MockHttpUrlConnection mockHttpUrlConnection = new MockHttpUrlConnection();
		mockHttpUrlConnection.setExpectedInputStream(new ByteArrayInputStream("It works".getBytes()));

		TestableWebClient1 client = new TestableWebClient1();
		client.setHttpURLConnection(mockHttpUrlConnection);

		String result = client.getContent(new URL("http://localhost"));
		assertEquals("It works", result);
	}

	@Test
	public void testGetContentOKByWebClient2() throws Exception {
		MockConnectionFactory mockConnectionFactory = new MockConnectionFactory();
		mockConnectionFactory.setInputStream(new ByteArrayInputStream("It works".getBytes()));

		WebClient2 webClient2 = new WebClient2();
		String result = webClient2.getContent(mockConnectionFactory);
		assertEquals("It works", result);
	}

	@Test
	public void testGetContentOKByClose() {
		MockInputStream mockInputStream = new MockInputStream();
		mockInputStream.setBuffer("It works");

		MockConnectionFactory mockConnectionFactory = new MockConnectionFactory();
		mockConnectionFactory.setInputStream(mockInputStream);

		WebClient3 webClient3 = new WebClient3();
		String result = webClient3.getContent(mockConnectionFactory);

		assertEquals("It works", result);
		mockInputStream.verify();
	}

	private class TestableWebClient1 extends WebClient1 {

		private HttpURLConnection httpURLConnection;

		public void setHttpURLConnection(HttpURLConnection httpURLConnection) {
			this.httpURLConnection = httpURLConnection;
		}

		@Override
		protected HttpURLConnection createHttpUrlConnection(URL url) throws IOException {
			return this.httpURLConnection;
		}
	}

}
