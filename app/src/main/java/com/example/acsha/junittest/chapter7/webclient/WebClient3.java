package com.example.acsha.junittest.chapter7.webclient;

import java.io.InputStream;

/**
 * @author dong.min.shin on 2016. 11. 14..
 */

public class WebClient3 {

	public String getContent(ConnectionFactory connectionFactory) {
		StringBuffer content = new StringBuffer();

		try (InputStream inputStream = connectionFactory.getData()) {
			int count;
			while (-1 != (count = inputStream.read())) {
				content.append(new String(Character.toChars(count)));
			}

		} catch (Exception e) {
			return null;

		}

		//		try {
		//			inputStream = connectionFactory.getData();
		//			int count;
		//			while (-1 != (count = inputStream.read())) {
		//				content.append(new String(Character.toChars(count)));
		//			}
		//
		//			result = content.toString();
		//
		//		} catch (Exception e) {
		//			result = null;
		//
		//		}
		//
		//		if (inputStream != null) {
		//			try {
		//				inputStream.close();
		//			} catch (IOException e) {
		//				result = null;
		//			}
		//		}

		return content.toString();
	}
}
