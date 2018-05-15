package com.NewsAgency.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="articles")
public class Article {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="writer_id")
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

	public Article(Integer id, Writer writer, String title, String articleAbstract, String body) {
		super();
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.articleAbstract = articleAbstract;
		this.body = body;
	}

	public Article(Writer writer, String title, String articleAbstract, String body) {
		// TODO Auto-generated constructor stub
		this.writer = writer;
		this.title = title;
		this.articleAbstract = articleAbstract;
		this.body = body;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Article [id=" + id  + ", title=" + title + ", articleAbstract=" + articleAbstract
				+ ", body=" + body + "]";
	}

	

	
	
}
