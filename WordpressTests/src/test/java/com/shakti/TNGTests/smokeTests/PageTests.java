package com.shakti.TNGTests.smokeTests;

import com.shakti.seleniumFrame.seleniumLogger.Log;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.shakti.TNGTests.utilities.WordpressTest;
import com.shakti.seleniumFrame.Pages.EditPostPage;
import com.shakti.seleniumFrame.Pages.ListPostsPage;
import com.shakti.seleniumFrame.Pages.ListPostsPage.PostType;

public class PageTests extends WordpressTest {

    @Parameters("titlePost")
	@Test
	public void User_Can_Edit_Post(String titlePost) {

        Log.startTestCase("User_Can_Edit_Post");

		Log.info("Navigating to List Post Page.");
		ListPostsPage.goTo(PostType.Page);

		Log.info("Selecting post with title Sample page.");
        ListPostsPage.selectPost(titlePost);

		Log.info("Verifying if Page is in Edit mode.");
		Assert.assertTrue(EditPostPage.isInEditMode(), "Was not in Edit mode.");

        Log.info("Verifying if Edit Page title matches.");
		Assert.assertEquals(EditPostPage.getTitle(), titlePost, "Title did not match.");

        Log.endTestCase("User_Can_Edit_Post");
	}
}
