package com.NewsAgency.communication.handlers;

public class ViewArticlesRequest {

	private String message ;

	public ViewArticlesRequest() {
		super();
		this.message="getArticles";
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
