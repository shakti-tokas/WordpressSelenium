package com.shakti.seleniumFrame.Navigation;


public class LeftNavigation {
	
	public static class Posts{
		
		public static class AddNew{

			public static void select() {
				
				// TODO Auto-generated method stub
				String xpathNewPost = "//div[contains(@class, 'wp-menu-name') and text()='Posts']";
				String linkNewPost = "Add New";
				
				MenuSelector.select(xpathNewPost, linkNewPost);
				
			}
			
		}
		
		public static class AllPosts{

			public static void select() {
				
				// TODO Auto-generated method stub
				String xpathAllPost = "//div[contains(@class, 'wp-menu-name') and text()='Posts']";
				String linkAllPost = "All Posts";
				
				MenuSelector.select(xpathAllPost, linkAllPost);
				
			}
			
		}
	}
	
	public static class Pages{
		
		public static class AllPages{

			public static void select() {
				
				// TODO Auto-generated method stub
				String xpathPage = "//div[contains(@class, 'wp-menu-name') and text()='Pages']";
				String linkPage = "All Pages";
				
				MenuSelector.select(xpathPage, linkPage);
				
			}
			
		}
	}
	
	public static class Categories{
		
			public static void select() {
				
				// TODO Auto-generated method stub
				String xpathNewPost = "//ul[contains(@class, 'wp-submenu')]/li/a[text()='Categories']";
				
				MenuSelector.select(xpathNewPost);
				
			}
	}

}
