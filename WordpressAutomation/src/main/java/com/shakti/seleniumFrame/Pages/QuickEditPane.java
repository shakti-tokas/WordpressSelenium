package com.shakti.seleniumFrame.Pages;

import org.openqa.selenium.By;

import com.shakti.seleniumFrame.seleniumDriver.Driver;

public class QuickEditPane {
	
	public static String QuickPaneId;
	
	public static String getQuickPaneId() {
		return QuickPaneId;
	}

	public static void setQuickPaneId(String postId) {
		String qId = postId.substring(5);
		String quickPaneId = "edit-"+qId;		
		QuickPaneId = quickPaneId;
	}

	public static boolean isEnabled() {
		// TODO Auto-generated method stub
		String cssPath = "tr#"+QuickPaneId+" td.colspanchange fieldset div h4";
		return Driver.Instance.findElement(By.cssSelector(cssPath)).isDisplayed();
	}

	public static String getTitle() {
		// TODO Auto-generated method stub
		String cssPath = "tr#"+QuickPaneId+" td.colspanchange fieldset div label span.input-text-wrap input.ptitle";
		return Driver.Instance.findElement(By.cssSelector(cssPath)).getAttribute("placeholder");
	}

	public static void cancelQuickEdit() {
		// TODO Auto-generated method stub
		String cssPath = "tr#"+QuickPaneId+" td.colspanchange p button.button-secondary.cancel.alignleft";
		Driver.Instance.findElement(By.cssSelector(cssPath)).click();
	}

}
