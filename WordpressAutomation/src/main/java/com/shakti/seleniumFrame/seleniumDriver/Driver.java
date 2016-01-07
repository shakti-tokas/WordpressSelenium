package com.shakti.seleniumFrame.seleniumDriver;

import java.util.concurrent.TimeUnit;

import com.shakti.seleniumFrame.Browsers.BrowserType;
import com.shakti.seleniumFrame.Browsers.GoogleChrome;
import com.shakti.seleniumFrame.Browsers.MicrosoftEdge;
import com.shakti.seleniumFrame.Browsers.MozillaFirefox;
import com.shakti.seleniumFrame.seleniumLogger.Log;
import org.openqa.selenium.WebDriver;


public class Driver {
	
	public static WebDriver Instance;
	public static String BaseAddress;
	
	public static String getBaseAddress() {
		return BaseAddress;
	}

	public static void setBaseAddress(String baseAddress) {
		BaseAddress = baseAddress;
	}

	public static WebDriver getInstance() {
		return Instance;
	}

	public static void setInstance(WebDriver instance) {
		Instance = instance;
	}

    public static void Initialize(BrowserType browserType) {

        switch (browserType){

            case Firefox:
                Instance = MozillaFirefox.InitializeFirefox();
                turnOnWait();
                BrowserMaximize();
                break;

            case Chrome:
                Instance = GoogleChrome.InitializeChrome();
                turnOnWait();
                BrowserMaximize();
                break;

            case Edge:
                Instance = MicrosoftEdge.InitializeEdge();
                turnOnWait();
                //BrowserMaximize();
                //In current build browser maximize is not supported by Microsoft Egde.
                break;
        }
    }

	public static void Close() {
		// TODO Auto-generated method stub
		Instance.close();
		Log.info("Driver closed.");
	}

	public static void turnOnWait() {
		// TODO Auto-generated method stub
		Instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Log.info("Driver Time-Out turned ON");
	}

	public static void turnOffWait() {
		// TODO Auto-generated method stub
		Instance.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
		Log.info("Driver Time-Out turned OFF");
	}

    public static void BrowserMaximize() {
        // TODO Auto-generated method stub
        Instance.manage().window().maximize();
    }
}
