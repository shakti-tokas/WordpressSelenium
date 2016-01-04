package com.shakti.seleniumFrame.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.shakti.seleniumFrame.seleniumDriver.Driver;

public class CheckBoxColumn {
	
	public static int CheckBoxCount;
	public static final String cssPathChkBox = "tr input[name='post[]']";
	
	public static int getCheckBoxCount() {
		return CheckBoxCount;
	}

	public static void setCheckBoxCount() {
		
		List<WebElement> rows = getListRows();
		int chkCount = 0;
		
		for (WebElement row : rows) {
						
			Driver.turnOffWait();
			List<WebElement> chks = row.findElements(By.cssSelector(cssPathChkBox));
			Driver.turnOnWait();
			chkCount = chkCount + chks.size();
			chks = null;
		}
		
		CheckBoxCount = chkCount;
	}

	public CheckBoxColumn(){
		setCheckBoxCount();
	}
	
	public static List<WebElement> getListRows(){
		return Driver.Instance.findElements(By.cssSelector("tbody#the-list tr"));
	}
	
	public static int countChkBoxes(boolean check) {
		// TODO Auto-generated method stub
		List<WebElement> rows = getListRows();	
		int chkCount = 0;
		
		for (WebElement row : rows) {
						
			Driver.turnOffWait();
			WebElement chk = row.findElement(By.cssSelector(cssPathChkBox));
			Driver.turnOnWait();
			
			if(check == chk.isSelected()){
				chkCount++;
			}
			
			chk = null;
		}
		return chkCount;
	}

	public static void selectAllChkBoxes() {
		// TODO Auto-generated method stub
		Driver.Instance.findElement(By.cssSelector("td#cb input#cb-select-all-1")).click();
	}

	public static void selectChkBox(String postId) {
		// TODO Auto-generated method stub
		String cId = postId.substring(5);
		String cssPath = "tr input#cb-select-"+cId;
		Driver.Instance.findElement(By.cssSelector(cssPath)).click();
	}

	public static void randomChkBoxSelector(int i) {
		// TODO Auto-generated method stub
		List<WebElement> rows = getListRows();	
		List<String> chk = new ArrayList<String>();
		
		for (WebElement row : rows) {
			Driver.turnOffWait();
			chk.add(row.getAttribute("id"));
			Driver.turnOnWait();
		}
		
		Random r = new Random();
		int cycle = r.nextInt(i)+i;
		
		for(int j=0; j < cycle; j++){			
			selectChkBox(chk.get(r.nextInt(chk.size())));
		}
	}
	
	public static ArrayList<String> getChkBoxPostIds(boolean check) {
		// TODO Auto-generated method stub
		List<WebElement> rows = getListRows();	
		ArrayList<String> postIds = new ArrayList<String>();
		
		for (WebElement row : rows) {
						
			Driver.turnOffWait();
			WebElement chk = row.findElement(By.cssSelector(cssPathChkBox));
			Driver.turnOnWait();
			
			if(check == chk.isSelected()){
				postIds.add(row.getAttribute("id"));			
			}
			
			chk = null;
		}
		return postIds;
	}

}
