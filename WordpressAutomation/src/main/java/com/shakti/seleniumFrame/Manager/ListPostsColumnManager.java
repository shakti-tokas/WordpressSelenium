package com.shakti.seleniumFrame.Manager;

import com.shakti.seleniumFrame.Navigation.Categories;
import com.shakti.seleniumFrame.Navigation.LeftNavigation;
import com.shakti.seleniumFrame.Pages.ListPostsPage;

public class ListPostsColumnManager extends ListPostsPage{
	
	public enum Columns{
		Checkbox, Title, Author, Categories, Tags, Comments, Date
	}
	
public static void Manage(Columns colType){
		
		switch (colType){
			
		case Checkbox:			
			new CheckBoxColumn();			
			break;
		
		case Title:
			
			break;
		
		case Author:			
			
			break;
		
		case Categories:			
			LeftNavigation.Categories.select();
			new Categories();
			break;
			
		case Comments:
			
			break;
			
		case Date:
			new DateColumn();
			break;
			
		case Tags:
			
			break;
		}
		
	}
	
}
