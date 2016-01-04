package com.shakti.seleniumFrame.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.shakti.seleniumFrame.seleniumDriver.Driver;

public class ViewPage {
	
	public static String ViewPageId;
	public static String ViewPageTitle;

	public static String getViewPageId() {
		return ViewPageId;
	}

	public static void setViewPageId(String postId) {		
		ViewPageId = postId;
	}

	public static String getViewPageTitle() {
		return ViewPageTitle;
	}

	public static void setViewPageTitle(String viewPageTitle) {
		ViewPageTitle = viewPageTitle;
	}

	public static boolean isOpened() {
		// TODO Auto-generated method stub
		boolean vFlag = false;
		String cssPath = "article#"+ViewPageId+" h1";
		WebElement viewArticle = Driver.Instance.findElement(By.cssSelector(cssPath));
		if(viewArticle.isDisplayed()){
			if(ViewPageTitle.equals(viewArticle.getText())){
				vFlag = true;
			}
		}
		return vFlag;
	}
	
	public static void exitViewPage(){
		Driver.Instance.findElement(By.xpath("//div[@id='wp-toolbar']/ul/li[@id='wp-admin-bar-site-name']/a[text()='Wordpress']")).click();		
	}
}
