package com.NewsAgency.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="articles")
public class Article {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer articleId;
	
	
	@ManyToOne
	@JoinColumn(name="writerId")
	private Writer writer;
	
	@Column
	private String title;
	
	@Column(name="abstract")
	private String articleAbstract;

	@Column
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
