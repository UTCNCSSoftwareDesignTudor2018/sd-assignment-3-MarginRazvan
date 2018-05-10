package com.NewsAgency.communication.handlers;

import java.util.List;

import com.NewsAgency.entity.Article;



public class ViewArticlesResponse {

	private List<Article> viewArticles;

	public ViewArticlesResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ViewArticlesResponse(List<Article> articles) {
		super();
		this.viewArticles = articles;
	}

	public List<Article> getArticles() {
		return viewArticles;
	}

	public void setArticles(List<Article> articles) {
		this.viewArticles = articles;
	}
	
}
