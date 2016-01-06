package com.shakti.seleniumFrame.Pages;

import com.shakti.seleniumFrame.seleniumLogger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shakti.seleniumFrame.seleniumDriver.Driver;

public class LoginPage {

	public static By userNameTextBox = By.id("user_login");
    public static By userPasswordTextBox = By.id("user_pass");
    public static By submitButton = By.id("wp-submit");

	public static final String LoginPageURL = "wp-login.php";

	public static void GoTo() {
		// TODO Auto-generated method stub
		// To make driver instance Global we created class Driver
		Driver.Instance.navigate().to(Driver.getBaseAddress() + LoginPageURL);
		Log.info("Navigated to WordPress Login Page");
		
		//Wait for the element to be visible on page
		WebDriverWait wait = new WebDriverWait(Driver.Instance,5);
		Log.info("Waiting until items start displaying.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(userNameTextBox));
	}

	public static LoginCommand LoginAs(String userName) {
		// TODO Auto-generated method stub		
		return new LoginCommand(userName);
	}
	
	public static class LoginCommand {
		private String userName;
		private String password;
		
		public LoginCommand(String userName){
			this.userName = userName;
		}
		
		public LoginCommand WithPassword(String password){			
			this.password = password;
			return this;			
		}

		public void Login() {
			// TODO Auto-generated method stub
			// Find and send UserName
			Driver.Instance.findElement(userNameTextBox).sendKeys(userName);
			Log.info("UserName Entered");

			//Find and send Password
			Driver.Instance.findElement(userPasswordTextBox).sendKeys(password);
			Log.info("Password Entered");

			//Find login button and send to press it
			Driver.Instance.findElement(submitButton).click();
			Log.info("Submit Clicked");
			
		}

	}

}
