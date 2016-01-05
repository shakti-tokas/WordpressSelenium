package com.shakti.TNGTests.smokeTests;

import com.shakti.seleniumFrame.seleniumLogger.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.shakti.TNGTests.utilities.WordpressTest;
import com.shakti.seleniumFrame.Navigation.NewPostPage;
import com.shakti.seleniumFrame.Pages.PostPage;

public class CreatePostTests extends WordpressTest {
	
	@Test
	public void User_Can_Create_Basic_Post() {

		Log.startTestCase("User_Can_Create_Basic_Post");

        Log.info("Navigating to Add New post page.");
		NewPostPage.goTo();

        Log.info("Creating New post.");

		NewPostPage.createPost("This is TestNG Test Post Title")
				.withBody("This is the body of TestNG post.").Publish();

        Log.info("Navigating to new post added in last step.");
		NewPostPage.goToNewPost();

        Log.info("Verifying the title of newly added post.");
		Assert.assertEquals(PostPage.getTitle(), "This is TestNG Test Post Title", "Title did not match new post.");

        Log.endTestCase("User_Can_Create_Basic_Post");
	}
  
}
