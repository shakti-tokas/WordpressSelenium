package com.shakti.seleniumFrame.Navigation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.shakti.seleniumFrame.seleniumDriver.Driver;

public class Categories {
	
	public static Map<String, Integer> CategoryTitles;
	
	public Categories(){
		setCategoryTitles();
	}
	
	public static Map<String, Integer> getCategoryTitles() {
		return CategoryTitles;
	}

	public static void setCategoryTitles() {
		
		CategoryTitles = new HashMap<String, Integer>();		
		List<WebElement> rows = Driver.Instance.findElements(By.cssSelector("form#posts-filter tbody#the-list tr"));
		
		for (WebElement row : rows) {
			
			Driver.turnOffWait();		
			CategoryTitles.put(row.findElement(By.cssSelector("strong a")).getText(), Integer.parseInt(row.findElement(By.cssSelector("td.posts a")).getText()));
			Driver.turnOnWait();
		}
	}
	
	
	
}
