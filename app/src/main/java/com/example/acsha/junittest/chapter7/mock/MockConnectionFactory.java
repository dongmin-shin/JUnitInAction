package com.example.acsha.junittest.chapter7.mock;

import java.io.InputStream;

import com.example.acsha.junittest.chapter7.webclient.ConnectionFactory;

/**
 * @author dong.min.shin on 2016. 11. 14..
 */

public class MockConnectionFactory implements ConnectionFactory {

	private InputStream inputStream;

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public InputStream getData() throws Exception {
		return this.inputStream;
	}
}
