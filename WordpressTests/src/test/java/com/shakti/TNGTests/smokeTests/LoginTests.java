package com.shakti.TNGTests.smokeTests;

import com.shakti.seleniumFrame.seleniumLogger.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.shakti.seleniumFrame.Pages.DashboardPage;
import com.shakti.TNGTests.utilities.WordpressTest;

public class LoginTests extends WordpressTest {
  
	@Test
	public void Admin_User_Can_Login() {

		Log.startTestCase("Admin_User_Can_Login");
		Assert.assertTrue(DashboardPage.IsAt(), "Failed to Login.");
        Log.endTestCase("Admin_User_Can_Login");
	}
	
}
