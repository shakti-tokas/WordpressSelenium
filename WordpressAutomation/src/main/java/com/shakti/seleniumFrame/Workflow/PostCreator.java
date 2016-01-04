package com.shakti.seleniumFrame.Workflow;

import java.util.Random;

import com.shakti.seleniumFrame.Navigation.NewPostPage;

public class PostCreator {
	
	public static String PostTitle;
	public static String PostBody;
	
	public static String getPostTitle() {
		return PostTitle;
	}

	public static void setPostTitle(String postTitle) {
		PostTitle = postTitle;
	}

	public static String getPostBody() {
		return PostBody;
	}

	public static void setPostBody(String postBody) {
		PostBody = postBody;
	}
	
	public static void createPost() {
		// TODO Auto-generated method stub		
		NewPostPage.goTo();
		
		setPostTitle(createTitle());
		setPostBody(createBody());
		
		NewPostPage.createPost(getPostTitle()).withBody(getPostBody()).Publish();		
	}

	private static String createBody() {
		// TODO Auto-generated method stub
		return  "Body:-" + createRandonString(7);
		//return "This is show body.";
	}

	private static String createTitle() {
		// TODO Auto-generated method stub
		return "Title:-" + createRandonString(1);
		//return "This is show title.";
	}
	
	private static String createRandonString(int len) {
		// TODO Auto-generated method stub
		StringBuilder s = new StringBuilder();		
		Random r = new Random();
		int cycle = r.nextInt(len)+1;
		
		for(int i=0; i < cycle; i++){			
			s.append(" ");
			s.append(words[r.nextInt(words.length)]);
			s.append(" ");
			s.append(article[r.nextInt(article.length)]);
			s.append(" ");
			s.append(words[r.nextInt(words.length)]);			
		}
		
		return s.toString();
	}
	
	private static String[] words = {"winters","cat","apple","news","orange","dummy","data","country","love"};
	private static String[] article = {"The","an","a","you","are","should","of","it","as","could","have"};

}
