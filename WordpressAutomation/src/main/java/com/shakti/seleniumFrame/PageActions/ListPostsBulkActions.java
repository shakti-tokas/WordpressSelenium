package com.shakti.seleniumFrame.PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.shakti.seleniumFrame.seleniumDriver.Driver;

public class ListPostsBulkActions {

	public static void doBulkAction(BulkActionType actionType){
		
		switch (actionType){
			
		case Edit:			
			executeBulkAction("edit");			
			break;
		
		case MoveToBin:
			executeBulkAction("trash");	
			break;
		}
		
	}
	
	public enum BulkActionType{
		Edit, MoveToBin
	}
	
	public static void executeBulkAction(String dropDownSelection) {
		// TODO Auto-generated method stub
		//Go to drop down
		Select bulkAxnDropDown = new Select(Driver.Instance.findElement(By.cssSelector("select#bulk-action-selector-top")));
		bulkAxnDropDown.selectByValue(dropDownSelection); //select the value as given
		//Press the Apply button
		Driver.Instance.findElement(By.cssSelector("input#doaction")).click();
	}

}
