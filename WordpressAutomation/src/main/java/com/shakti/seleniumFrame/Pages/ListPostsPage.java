package com.shakti.seleniumFrame.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.shakti.seleniumFrame.Navigation.LeftNavigation;
import com.shakti.seleniumFrame.seleniumDriver.Driver;

public class ListPostsPage {
	
	public static int CurrentPostCount;
	
	public static int getCurrentPostCount() {
		return getPostCount();
	}

	public static int PreviousPostCount;
	
	public static int getPreviousPostCount() {
		return lastCount;
	}
	
	private static int lastCount;
	
	public static int getLastCount() {
		return lastCount;
	}

	public static void setLastCount(int lastCount) {
		ListPostsPage.lastCount = lastCount;
	}

	public static void goTo(PostType postType){
		
		switch (postType){
			
		case Page:
			
			LeftNavigation.Pages.AllPages.select();			
			break;
		
		case Posts:
			LeftNavigation.Posts.AllPosts.select();
			break;
		}
		
	}
	
	public enum PostType{
		Page, Posts
	}

	public static void selectPost(String title) {
		// TODO Auto-generated method stub
		WebElement postLink = Driver.Instance.findElement(By.linkText(title));
		postLink.click();
	}

	public static void storeCount() {
		// TODO Auto-generated method stub
		setLastCount(getPostCount());
	}

	private static int getPostCount() {
		// TODO Auto-generated method stub
		String countText = Driver.Instance.findElement(By.className("displaying-num")).getText();
		return Integer.parseInt(countText.split(" ")[0]);
	}

	public static boolean doesPostExistWithTitle(String title) {
		// TODO Auto-generated method stub
		return Driver.Instance.findElement(By.linkText(title)).isDisplayed();
	}

	public static void searchForPost(String searchString) {
		// TODO Auto-generated method stub
		WebElement searchBox = Driver.Instance.findElement(By.id("post-search-input"));
		searchBox.sendKeys(searchString);
		
		WebElement searchSubmit = Driver.Instance.findElement(By.id("search-submit"));
		searchSubmit.click();
	}

	public static String getPostId(String post_title) {
		// TODO Auto-generated method stub
		List<WebElement> rows = Driver.Instance.findElements(By.tagName("tr"));	
		
		for (WebElement row : rows) {
						
			Driver.turnOffWait();			
			List<WebElement> links = row.findElements(By.linkText(post_title));
			Driver.turnOnWait();
			
			if(!links.isEmpty()){		
				return row.getAttribute("id");
			}
				links = null;
		} return null;
	}

}
