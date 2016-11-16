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
public class TestWebClient4 {

	@Mock
	private ConnectionFactory connectionFactory;

	@InjectMocks
	private WebClient4 webClient4;

	@Test
	public void testGetContentOK() throws Exception {
		// given
		ByteArrayInputStream byteArrayInputStream = Mockito.spy(new ByteArrayInputStream("It works".getBytes()));
		when(connectionFactory.getData()).thenReturn(byteArrayInputStream);

		// when
		String result = webClient4.getContent(connectionFactory);

		// then
		assertEquals("It works", result);
		verify(byteArrayInputStream, times(1)).close();
	}

}
