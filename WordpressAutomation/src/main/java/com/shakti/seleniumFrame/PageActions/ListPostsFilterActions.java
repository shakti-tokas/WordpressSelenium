package com.shakti.seleniumFrame.PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.shakti.seleniumFrame.seleniumDriver.Driver;

public class ListPostsFilterActions {
	
	public static void doFilterAction(FilterActionType actionType, String actionValue){
		
		switch (actionType){
			
		case Date:			
			selectFilterAction("form#posts-filter select#filter-by-date",actionValue);
			filter();
			break;
		
		case Category:
			selectFilterAction("form#posts-filter select#cat",actionValue);	
			filter();
			break;
		}
		
	}

	public static void doFilterActions(String dateValue, String categoryValue){
			
		selectFilterAction("form#posts-filter select#filter-by-date",dateValue);			

		selectFilterAction("form#posts-filter select#cat",categoryValue);
		
		filter();
			
	}	
	
	private static void filter() {
		// TODO Auto-generated method stub
		Driver.Instance.findElement(By.cssSelector("input#post-query-submit")).click();
	}

	public enum FilterActionType{
		Date, Category
	}
	
	public static void selectFilterAction(String dropDownSelection, String selectionValue) {
		// TODO Auto-generated method stub
		//Go to drop down
		Select filterAxnDropDown = new Select(Driver.Instance.findElement(By.cssSelector(dropDownSelection)));
		filterAxnDropDown.selectByVisibleText(selectionValue); //select the value as given		
	}
	
}
