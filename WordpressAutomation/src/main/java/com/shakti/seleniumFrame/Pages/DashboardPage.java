package com.shakti.seleniumFrame.Pages;

import com.shakti.seleniumFrame.seleniumLogger.Log;
import org.openqa.selenium.By;

import com.shakti.seleniumFrame.seleniumDriver.Driver;

public class DashboardPage {

	public static boolean IsAt() {
		// TODO Auto-generated method stub
		Log.info("Verifying Dashboard Title");
		int dash = Driver.Instance.findElements(By.tagName("h1")).size();
		
		if (dash > 0){
			Log.info("Dashboard Title found");
			return true;
		}
		else {
			Log.info("Dashboard Title NOT found");
			return false;
		}		
	}

}
