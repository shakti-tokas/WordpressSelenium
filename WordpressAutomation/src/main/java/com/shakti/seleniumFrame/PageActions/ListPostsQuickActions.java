package com.shakti.seleniumFrame.PageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.shakti.seleniumFrame.seleniumDriver.Driver;

public class ListPostsQuickActions {
		
	public enum QuickActionType{
		Edit, QuickEdit, Bin, View
	}
	
	public static void doQuickAction(QuickActionType actionType, String postTitle){
		
		switch (actionType){
			
		case Edit:			
			quickPostAction(postTitle,"Edit");			
			break;
		
		case QuickEdit:
			quickPostAction(postTitle,"Quick Edit");
			break;
		
		case Bin:			
			quickPostAction(postTitle,"Bin");
			break;
		
		case View:
			quickPostAction(postTitle,"View");
			break;
		}
		
	}
	
	public static void quickPostAction(String post_title, String link_name){
		
		List<WebElement> rows = Driver.Instance.findElements(By.tagName("tr"));	
		
		for (WebElement row : rows) {
						
			Driver.turnOffWait();
			List<WebElement> links = row.findElements(By.linkText(post_title));
			Driver.turnOnWait();
			
			if(!links.isEmpty()){
				Actions action = new Actions(Driver.Instance);
				action.moveToElement(links.get(0));
				action.perform();
				row.findElement(By.linkText(link_name)).click();
				return;
			}
				links = null;
		}
	}

}
