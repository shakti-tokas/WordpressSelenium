package com.shakti.seleniumFrame.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.shakti.seleniumFrame.seleniumDriver.Driver;

public class PostPage {

	public static String Title;
	public static final String Empty_String = "";

	public static String getTitle() {
		WebElement title_new_post = Driver.Instance.findElement(By.className("entry-title"));
		
		if(title_new_post != null){
			Title = title_new_post.getText();
			return Title;
		} else {
			return Empty_String;
		}		
	}

	public static void setTitle(String title) {
		Title = title;
	}
	
}
