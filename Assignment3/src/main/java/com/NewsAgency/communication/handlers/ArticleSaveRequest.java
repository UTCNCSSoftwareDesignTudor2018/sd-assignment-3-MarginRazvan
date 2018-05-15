package com.NewsAgency.communication.handlers;

import com.NewsAgency.persistence.entity.Article;

public class ArticleSaveRequest {

	private Article articleToSave;

	public ArticleSaveRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ArticleSaveRequest(Article articleToSave) {
		super();
		this.articleToSave = articleToSave;
	}



	public Article getArticleToSave() {
		return articleToSave;
	}

	public void setArticleToSave(Article articleToSave) {
		this.articleToSave = articleToSave;
	}
	
}
