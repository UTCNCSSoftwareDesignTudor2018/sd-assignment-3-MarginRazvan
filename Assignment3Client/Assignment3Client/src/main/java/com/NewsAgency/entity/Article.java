package com.NewsAgency.entity;







public class Article {
	
	private Integer articleId;
	
	private Writer writer;
	

	private String title;
	

	private String articleAbstract;


	private String body;

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(Integer articleId, Writer writer, String title, String articleAbstract, String body) {
		super();
		this.articleId = articleId;
		this.writer = writer;
		this.title = title;
		this.articleAbstract = articleAbstract;
		this.body = body;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticleAbstract() {
		return articleAbstract;
	}

	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
