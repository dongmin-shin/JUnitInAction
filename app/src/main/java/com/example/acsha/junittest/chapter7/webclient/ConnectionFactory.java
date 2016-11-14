package com.example.acsha.junittest.chapter7.webclient;

import java.io.InputStream;

/**
 * @author dong.min.shin on 2016. 11. 14..
 */

public interface ConnectionFactory {

	InputStream getData() throws Exception;
}
