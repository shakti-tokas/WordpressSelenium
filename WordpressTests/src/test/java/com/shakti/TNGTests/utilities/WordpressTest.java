package com.shakti.TNGTests.utilities;

import com.shakti.seleniumFrame.seleniumLogger.Log;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.shakti.seleniumFrame.Pages.LoginPage;
import com.shakti.seleniumFrame.seleniumDriver.Driver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class WordpressTest {

	@BeforeSuite
	public static void initSuite(){
		Log.Initialize();
	}

    @Parameters({"wordPressURL","browser"})
	@BeforeClass
	public static void initTestClass(String wordPressURL, String browser){

        Log.info("Initializing the "+ browser +" Browser");
        InitializeDriver(browser);

		Driver.setBaseAddress(wordPressURL);

		Log.info("Navigating to Login Page");
		LoginPage.GoTo();

		Log.info("Start Entering UserName and Password");
		LoginPage.LoginAs("shaz1985").WithPassword("13jxesD7&RayJpiHN1").Login();
	}
	
	@AfterClass
	public static void cleanupTestClass(){
		Log.info("Closing the Browser. Bye!!");
		Driver.Close();
	}

    public static void InitializeDriver(String browser){

        try {
            switch (browser) {

                case "Firefox":
                    Driver.Initialize(Driver.BrowserType.Firefox);
                    break;

                case "Chrome":
                    Driver.Initialize(Driver.BrowserType.Chrome);
                    break;

                case "Edge":
                    Driver.Initialize(Driver.BrowserType.Edge);
                    break;

                default:
                    Log.fatal("No such Browser is supported by this application.");
                    throw new IllegalArgumentException();
            }
        }catch (Exception e){
            Log.fatal(e.getMessage());
        }
    }

}
