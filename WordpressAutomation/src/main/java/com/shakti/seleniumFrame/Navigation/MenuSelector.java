package com.shakti.seleniumFrame.Navigation;

import org.openqa.selenium.By;

import com.shakti.seleniumFrame.seleniumDriver.Driver;

public class MenuSelector {
	
	public static void select(String xpathId, String linkId){
		
		Driver.Instance.findElement(By.xpath(xpathId)).click();			
		Driver.Instance.findElement(By.linkText(linkId)).click();
	}
	
	public static void select(String xpathId){
		
		Driver.Instance.findElement(By.xpath(xpathId)).click();			
	}

}
