package com.shakti.seleniumFrame.Browsers;

import com.shakti.seleniumFrame.seleniumLogger.Log;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by stokas on 06-01-2016.
 */
public class GoogleChrome {
    private static final String chromePath = "E:\\GitHub\\WordpressSelenium\\WordpressAutomation\\src\\main\\resources\\Ext_WebDrivers\\chromedriver.exe";

	public static ChromeDriver InitializeChrome(){

		Log.info("Initializing the Chrome Driver");
        System.setProperty("webdriver.chrome.driver", chromePath);
		return new ChromeDriver();
	}
}
