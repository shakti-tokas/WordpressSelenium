package com.shakti.seleniumFrame.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.shakti.seleniumFrame.seleniumDriver.Driver;

public class EditPostPage {
	public static String Title;
	public static final String Empty_String = "";
	
	public static String getTitle() {
		WebElement title_edit_post = Driver.Instance.findElement(By.id("title"));
		
		if(title_edit_post != null){
			Title = title_edit_post.getAttribute("value");
			return Title;
		} else {
			return Empty_String;
		}		
	}

	public static void setTitle(String title) {
		Title = title;
	}
	
	public static boolean isInEditMode() {
		// TODO Auto-generated method stub
		return Driver.Instance.findElement(By.xpath("//div[contains(@class, 'wrap')]/h1")) != null;
	}	

}
