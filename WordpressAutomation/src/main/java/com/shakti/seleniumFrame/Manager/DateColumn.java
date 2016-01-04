package com.shakti.seleniumFrame.Manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.shakti.seleniumFrame.seleniumDriver.Driver;

public class DateColumn {
	
	public static Map<String, Integer> ColDates;
	
	public static Map<String, Integer> getColDates() {
		return ColDates;
	}

	public static void setColDates() {
		
		ColDates = new HashMap<String, Integer>();
		List<String> dates = new ArrayList<String>();
		List<WebElement> rows = Driver.Instance.findElements(By.cssSelector("form#posts-filter tbody#the-list tr"));
		
		for (WebElement row : rows) {
			
			Driver.turnOffWait();
			String str[] = row.findElement(By.cssSelector("td abbr")).getText().split("/");
			String mm_yyyy = str[1]+"/"+str[0];
			dates.add(mm_yyyy);
			Driver.turnOnWait();
		}
		
		Set<String> uniqueDates = new HashSet<String>(dates);
		Iterator<String> itrDate = uniqueDates.iterator();
		
		while(itrDate.hasNext()) {
			
			String tempDate = itrDate.next();
			ColDates.put(tempDate, Collections.frequency(dates, tempDate));
		}
		//System.out.println(ColDates);
	}

	public DateColumn(){
		setColDates();
	}

}
