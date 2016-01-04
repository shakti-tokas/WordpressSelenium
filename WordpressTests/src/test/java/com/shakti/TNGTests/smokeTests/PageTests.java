package com.shakti.TNGTests.smokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.shakti.TNGTests.utilities.WordpressTest;
import com.shakti.seleniumFrame.Pages.EditPostPage;
import com.shakti.seleniumFrame.Pages.ListPostsPage;
import com.shakti.seleniumFrame.Pages.ListPostsPage.PostType;

public class PageTests extends WordpressTest {
	
	@Test
	public void User_Can_Edit_Post() {
					
		ListPostsPage.goTo(PostType.Page);
		ListPostsPage.selectPost("Sample Page");
		
		Assert.assertTrue(EditPostPage.isInEditMode(), "Was not in Edit mode.");
		Assert.assertEquals(EditPostPage.getTitle(), "Sample Page", "Title did not match.");
	}
}
