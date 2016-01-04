package com.shakti.TNGTests.smokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.shakti.TNGTests.utilities.WordpressTest;
import com.shakti.seleniumFrame.Navigation.NewPostPage;
import com.shakti.seleniumFrame.Pages.PostPage;

public class CreatePostTests extends WordpressTest {
	
	@Test
	public void User_Can_Create_Basic_Post() {								
		
		NewPostPage.goTo();
		
		NewPostPage.createPost("This is TestNG Test Post Title")
				.withBody("This is the body of TestNG post.").Publish();
		
		NewPostPage.goToNewPost();
		
		Assert.assertEquals(PostPage.getTitle(), "This is TestNG Test Post Title", "Title did not match new post.");
	}
  
}
