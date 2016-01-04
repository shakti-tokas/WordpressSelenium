package com.shakti.TNGTests.postsTests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.shakti.seleniumFrame.Manager.CheckBoxColumn;
import com.shakti.seleniumFrame.Manager.DateColumn;
import com.shakti.seleniumFrame.Manager.ListPostsColumnManager;
import com.shakti.seleniumFrame.Manager.ListPostsColumnManager.Columns;
import com.shakti.seleniumFrame.Navigation.Categories;
import com.shakti.seleniumFrame.PageActions.ListPostsBulkActions;
import com.shakti.seleniumFrame.PageActions.ListPostsBulkActions.BulkActionType;
import com.shakti.seleniumFrame.PageActions.ListPostsFilterActions;
import com.shakti.seleniumFrame.PageActions.ListPostsFilterActions.FilterActionType;
import com.shakti.seleniumFrame.PageActions.ListPostsQuickActions;
import com.shakti.seleniumFrame.PageActions.ListPostsQuickActions.QuickActionType;
import com.shakti.seleniumFrame.Pages.BulkEditPane;
import com.shakti.seleniumFrame.Pages.EditPostPage;
import com.shakti.seleniumFrame.Pages.ListPostsPage;
import com.shakti.seleniumFrame.Pages.ListPostsPage.PostType;
import com.shakti.seleniumFrame.Pages.QuickEditPane;
import com.shakti.seleniumFrame.Pages.ViewPage;
import com.shakti.seleniumFrame.Workflow.PostCreator;
import com.shakti.TNGTests.utilities.WordpressTest;


public class AllPostsTests extends WordpressTest {
	
	@Test
	public void Single_Post_Actions(){
		
		//Add posts - Create a new post
		//PostCreator.createPost();
		//final String qTitle = PostCreator.getPostTitle();
		final String qTitle = "Quick link test post";
		
		//Go to List Posts
		ListPostsPage.goTo(PostType.Posts);
		
		//Select the title and assert - Check that post shows up in results
		Assert.assertTrue(ListPostsPage.doesPostExistWithTitle(qTitle));
		
		//Go back to posts - already on page		
		ListPostsQuickActions.doQuickAction(QuickActionType.Edit, qTitle);//Click edit and assert
		
		Assert.assertTrue(EditPostPage.isInEditMode(),"Was not in Edit mode.");
		Assert.assertEquals("Title did not match.", qTitle, EditPostPage.getTitle());
		
		//Go back to posts
		ListPostsPage.goTo(PostType.Posts);
		
		//Get post id & click quick edit assert title and section	
		QuickEditPane.setQuickPaneId(ListPostsPage.getPostId(qTitle));
		ListPostsQuickActions.doQuickAction(QuickActionType.QuickEdit, qTitle);
		
		Assert.assertTrue(QuickEditPane.isEnabled(), "Was not in Quick Edit mode.");
		
		//go back to post by cancel
		QuickEditPane.cancelQuickEdit();
		
		//view post assert title
		ViewPage.setViewPageId(ListPostsPage.getPostId(qTitle));
		ViewPage.setViewPageTitle(qTitle);
		ListPostsQuickActions.doQuickAction(QuickActionType.View, qTitle);
		
		Assert.assertTrue(ViewPage.isOpened(), "Post is not in View mode.");
		ViewPage.exitViewPage();
	}
	
	@Test
	public void Bulk_Actions(){
		
		//1
		//Go to All Posts
		ListPostsPage.goTo(PostType.Posts);
		
		ListPostsColumnManager.Manage(Columns.Checkbox);
		CheckBoxColumn.selectChkBox("post-114");
		CheckBoxColumn.selectChkBox("post-8"); //select single checkbox based on post id

		Assert.assertEquals(CheckBoxColumn.countChkBoxes(true), 2, "Selected checkbox count is different.");

		CheckBoxColumn.selectAllChkBoxes(); 		//Select SINGLE ALL checkbox
		
		//Assert all n checkbox are checked	
		Assert.assertEquals(CheckBoxColumn.countChkBoxes(true), CheckBoxColumn.CheckBoxCount, "All checkboxes not selected.");
		CheckBoxColumn.selectAllChkBoxes();  //deselect all chkboxes
		
		//2
		//Go to All Posts
		ListPostsPage.goTo(PostType.Posts);
		
		//Select any 4 posts
		CheckBoxColumn.randomChkBoxSelector(5);
		System.out.println(CheckBoxColumn.countChkBoxes(true));
		//Use Bulk Action Edit
		BulkEditPane.setBulkPaneIds(CheckBoxColumn.getChkBoxPostIds(true));
		System.out.println(BulkEditPane.BulkPaneIds.get(1));
		ListPostsBulkActions.doBulkAction(BulkActionType.Edit);
		//Assert Edit section
		Assert.assertTrue(BulkEditPane.isEnabled(), "Bulk Edit section is not displayed.");
		//Remove post from Edit section
		ArrayList<String> pids = new ArrayList<String>();
		pids.add(BulkEditPane.BulkPaneIds.get(1));
		BulkEditPane.removePostsFromEdit(pids);
		
		Assert.assertEquals(BulkEditPane.countOfPostInPane(), BulkEditPane.BulkPaneIds.size()-pids.size(), "Bulk Edit Ids don't match.");
		//exit Bulk edit pane
		//Update edit and assert changes
		
		//3
		//Go to All Posts
		//Get count of posts: n
		ListPostsPage.goTo(PostType.Posts);
		ListPostsPage.storeCount();
		//Select any 2 posts
		CheckBoxColumn.randomChkBoxSelector(3);
		int moveToBinCount = CheckBoxColumn.countChkBoxes(true);
		//Use Bulk Action Trash
		ListPostsBulkActions.doBulkAction(BulkActionType.MoveToBin);		
		//Assert items are trashed
		Assert.assertEquals(ListPostsPage.getCurrentPostCount(), (ListPostsPage.getLastCount() - moveToBinCount), "Failed to Delete Bulk Posts.");
		
	}
	
	@Test
	public void Filter_Actions(){
		//drop down filters test - Go to All Posts
		
		ListPostsPage.goTo(PostType.Posts);
		ListPostsPage.storeCount();
		
		//can filter by month
		ListPostsColumnManager.Manage(Columns.Date);
		ListPostsFilterActions.doFilterAction(FilterActionType.Date, "November 2015");
		Assert.assertEquals(ListPostsPage.getCurrentPostCount(), DateColumn.getColDates().get("11/2015").intValue(), "Failed to filter based on Date.");
		
		//can filter by category		
		ListPostsColumnManager.Manage(Columns.Categories);		
		ListPostsPage.goTo(PostType.Posts);
		ListPostsFilterActions.doFilterAction(FilterActionType.Category, "test_category");
		Assert.assertEquals( ListPostsPage.getCurrentPostCount(), Categories.getCategoryTitles().get("test_category").intValue(), "Failed to filter based on categories.");
		//can view published only: Filter Not available in site
		//can view drafts only: Filter Not available in site
		//can view trash only: Filter Not available in site */
	}
	
	@Test
	public void Added_Posts_Show_Up(){
		
		//Go to posts, get post count, store
		ListPostsPage.goTo(PostType.Posts);
		ListPostsPage.storeCount();
		
		//Add a new post
		PostCreator.createPost();			
		
		//Go to posts, get new post count
		ListPostsPage.goTo(PostType.Posts);
		Assert.assertEquals(ListPostsPage.getCurrentPostCount(), ListPostsPage.getLastCount() + 1, "Failed to Add Post.");
		
		//check for added post
		Assert.assertTrue(ListPostsPage.doesPostExistWithTitle(PostCreator.getPostTitle()));
		
		//Trash post (clean up)
		ListPostsQuickActions.doQuickAction(QuickActionType.Bin, PostCreator.getPostTitle());
		Assert.assertEquals(ListPostsPage.getCurrentPostCount(), ListPostsPage.getLastCount(), "Failed to bin post.");
		
	}
	
	@Test
	public void Can_Search_Posts(){
		
		//Create a new post
		PostCreator.createPost();
		
		//Go to List Posts
		ListPostsPage.goTo(PostType.Posts);
		
		//Search for post
		ListPostsPage.searchForPost(PostCreator.getPostTitle());
		
		//Check that post shows up in results
		Assert.assertTrue(ListPostsPage.doesPostExistWithTitle(PostCreator.getPostTitle()));
		
		//cleanup trash post
		ListPostsQuickActions.doQuickAction(QuickActionType.Bin, PostCreator.getPostTitle());
		
	}

}
