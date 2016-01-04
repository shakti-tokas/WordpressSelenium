package com.shakti.seleniumFrame.seleniumDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import com.shakti.seleniumFrame.seleniumLogger.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Driver {
	
	public static WebDriver Instance;
	public static String BaseAddress;
	
	public static String getBaseAddress() {
		return "http://localhost:51396/";
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
	
	public static void Initialize(){

		Log.info("Initializing the Driver");
		FirefoxProfile instanceProfile = getProfile();
		//instanceProfile.setPreference("browser.startup.homepage", "about:home");
		Instance = new FirefoxDriver(instanceProfile);
		Log.info("Profile Fetched");
		turnOnWait();
		Instance.manage().window().maximize();
	}
	
	public static FirefoxProfile getProfile() {
		// TODO Auto-generated method stub
		//ProfilesIni allProfiles = new ProfilesIni();		
		//return allProfiles.getProfile("testNGUser");
		Log.info("Fetching Firefox Profile");
		String profilePath = "C:\\Users\\stokas\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\gq9ow771.testNGUser";
		return new FirefoxProfile(new File(profilePath));
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

}
