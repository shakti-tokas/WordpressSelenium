package com.shakti.TNGTests.utilities;

import com.shakti.seleniumFrame.seleniumLogger.Log;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.shakti.seleniumFrame.Pages.LoginPage;
import com.shakti.seleniumFrame.seleniumDriver.Driver;

public class WordpressTest {
  
	@BeforeClass
	public static void init(){

		Log.logInitialize();
		Log.info("Initializing the Browser");
		Driver.Initialize();

		Log.info("Navigating to Login Page");
		LoginPage.GoTo();

		Log.info("Start Entering UserName and Password");
		LoginPage.LoginAs("shaz1985").WithPassword("13jxesD7&RayJpiHN1").Login();
	}
	
	@AfterClass
	public static void cleanup(){
		Log.info("Closing the Browser. Bye!!");
		Driver.Close();
	}

}