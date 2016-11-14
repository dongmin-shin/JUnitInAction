package com.example.acsha.junittest.chapter7.webclient;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author dong.min.shin on 2016. 11. 14..
 */

@RunWith(MockitoJUnitRunner.class)
public class TestWebClient2 {

	@Mock
	private ConnectionFactory connectionFactory;

	@InjectMocks
	private WebClient3 webClient3;

	@Test
	public void testGetContentOK() throws Exception {
		// given
		ByteArrayInputStream byteArrayInputStream = Mockito.spy(new ByteArrayInputStream("It works".getBytes()));
		when(connectionFactory.getData()).thenReturn(byteArrayInputStream);

		// when
		String result = webClient3.getContent(connectionFactory);

		// then
		assertEquals("It work1s", result);
		verify(byteArrayInputStream, times(1)).close();
	}

}
