package com.example.acsha.junittest;

import static org.junit.Assert.*;
import static org.robolectric.Shadows.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import android.content.Context;
import android.content.Intent;

/**
 * @author dong.min.shin on 2016. 11. 4..
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {

	@Test
	public void testSample() {
		assertTrue(true);
	}

	@Test
	public void testResourceLoad() {
		Context context = RuntimeEnvironment.application;
		String appName = context.getResources().getString(R.string.app_name);
		assertEquals("JUnitTest", appName);
	}

	@Test
	public void clickingLogin_shouldStartLoginActivity() {
		MainActivity activity = Robolectric.setupActivity(MainActivity.class);
		activity.findViewById(R.id.login).performClick();

		Intent expectedIntent = new Intent(activity, LoginActivity.class);
		assertEquals(expectedIntent.getClass(), shadowOf(activity).getNextStartedActivity().getClass());
	}

}