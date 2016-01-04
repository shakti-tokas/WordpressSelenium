package com.shakti.seleniumFrame.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.shakti.seleniumFrame.seleniumDriver.Driver;

public class BulkEditPane {
	
	public static ArrayList<String> BulkPaneIds;

	public static ArrayList<String> getBulkPaneIds() {
		return BulkPaneIds;
	}

	public static void setBulkPaneIds(ArrayList<String> bulkPaneIds) {
		BulkPaneIds = bulkPaneIds;
	}
	
	public static boolean isEnabled() {
		// TODO Auto-generated method stub
		return Driver.Instance.findElement(By.cssSelector("tr#bulk-edit div h4")).isDisplayed();
	}

	public static void removePostFromEdit(String postId) {
		// TODO Auto-generated method stub
		String cId = postId.substring(5);
		String cssPath = "tr#bulk-edit fieldset.inline-edit-col-left a#_"+cId;
		Driver.Instance.findElement(By.cssSelector(cssPath)).click();
	}
	
	public static void removePostsFromEdit(ArrayList<String> postIds) {
		// TODO Auto-generated method stub
		for(int i = 0; i<postIds.size(); i++){
			removePostFromEdit(postIds.get(i));
		}
	}

	public static int countOfPostInPane() {
		// TODO Auto-generated method stub
		List<WebElement> links = Driver.Instance.findElements(By.cssSelector("tr#bulk-edit fieldset.inline-edit-col-left a"));
		return links.size();
	}

}
