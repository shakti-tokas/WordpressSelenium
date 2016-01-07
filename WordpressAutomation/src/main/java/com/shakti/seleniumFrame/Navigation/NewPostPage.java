package com.shakti.seleniumFrame.Navigation;

import java.util.concurrent.TimeUnit;

import com.shakti.seleniumFrame.seleniumLogger.Log;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;

import com.shakti.seleniumFrame.seleniumDriver.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPostPage {
    public static By TitleBox = By.id("title");
    public static String PostBodyFrame = "content_ifr";
    public static By PublishButton = By.id("publish");
    public static By ViewPostLink = By.linkText("View post");

    public static void goTo () {
        // TODO Auto-generated method stub
        Log.info("Navigating to Add new post page.");
        LeftNavigation.Posts.AddNew.select();
    }

    public static CreatePostCommand createPost(String title) {
        // TODO Auto-generated method stub
        return new CreatePostCommand(title);
    }

    public static void goToNewPost() {
        // TODO Auto-generated method stub
        try {
            Log.info("Navigating to new post.");
            Driver.Instance.findElement(ViewPostLink).click();
        }catch (Exception e) {
            Log.error(e.toString());
            //Driver.Close();
        }
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
                Log.info("Typing title for new post.");
                Driver.Instance.findElement(TitleBox).sendKeys(title);

                //Switch to frame with text field to write post
                Driver.Instance.switchTo().frame(PostBodyFrame);
                Log.info("Typing Body for new post.");
                Driver.Instance.switchTo().activeElement().sendKeys(body);
                Driver.Instance.switchTo().defaultContent(); //Control back to main title page

                //Publish the post
                Log.info("Publishing new post.");
                Driver.Instance.findElement(PublishButton).submit();

                WebDriverWait wait = new WebDriverWait(Driver.Instance,15);
                Log.info("Waiting until post is published.");
                wait.until(ExpectedConditions.visibilityOfElementLocated(ViewPostLink));
		}
			catch (UnhandledAlertException f) {
		        Alert alert = Driver.Instance.switchTo().alert();
		        String alertText = alert.getText();
                Log.error("Alert data: " + alertText);
		        alert.accept();
		        //Driver.Close();
		}
			catch (Exception e) {
				Log.error(e.toString());
				//Driver.Close();
			}

	    }

    }
}


