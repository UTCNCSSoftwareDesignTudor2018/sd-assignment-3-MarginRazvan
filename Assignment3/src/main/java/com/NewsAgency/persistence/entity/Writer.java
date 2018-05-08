package com.NewsAgency.persistence.entity;

import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="writers")
public class Writer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer writerId;
	
	
	@OneToMany(mappedBy="writer")
	@JsonIgnore
	private List<Article> articles;
	
	@Column
	private String name;

	
	@Column
	private String email;
	
	@Column
	private String password;

	public Writer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Writer(String name, String email, String password) {
		super();
		this.articles = new ArrayList<Article>();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Integer getWriterId() {
		return writerId;
	}

	public void setWriterId(Integer writerId) {
		this.writerId = writerId;
	}

	public List<Article> getArticles() {
		return articles;
	}
	
	public void addArticle(Article article)
	{
		this.articles.add(article);
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Writer [writerId=" + writerId + ", name=" + name + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
	
}
