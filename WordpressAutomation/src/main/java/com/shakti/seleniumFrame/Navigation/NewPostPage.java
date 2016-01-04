package com.shakti.seleniumFrame.Navigation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;

import com.shakti.seleniumFrame.seleniumDriver.Driver;

public class NewPostPage {

	public static void goTo() {
		// TODO Auto-generated method stub
		LeftNavigation.Posts.AddNew.select();		
	}

	public static CreatePostCommand createPost(String title) {
		// TODO Auto-generated method stub
		return new CreatePostCommand(title);
	}
	
	public static void goToNewPost() {
		// TODO Auto-generated method stub
		Driver.Instance.findElement(By.linkText("View post")).click();
	}

	public static class CreatePostCommand {
		private String title;
		private String body;
		
		public CreatePostCommand(String title){
			this.title = title;
		}
		
		public CreatePostCommand withBody(String body){
			this.body = body;
			return this;
		}
		
		public void Publish(){
			//
			try{
			//Find title text box and enter title
			Driver.Instance.findElement(By.id("title")).sendKeys(title);;
			
			//Switch to frame with text field to write post
			Driver.Instance.switchTo().frame("content_ifr");
			Driver.Instance.switchTo().activeElement().sendKeys(body);
			Driver.Instance.switchTo().defaultContent(); //Control back to main title page			
			
			//Publish the post
			Driver.Instance.findElement(By.id("publish")).click();
			Driver.Instance.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
			catch (UnhandledAlertException f) {
		        Alert alert = Driver.Instance.switchTo().alert();
		        String alertText = alert.getText();
		        System.out.println("Alert data: " + alertText);
		        alert.accept();
		        Driver.Close();
		}
		
	}

}}


