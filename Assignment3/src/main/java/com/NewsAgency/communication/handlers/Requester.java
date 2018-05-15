package com.NewsAgency.communication.handlers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NewsAgency.business.ArticleBLLInterface;
import com.NewsAgency.business.WriterBLLInterface;
import com.NewsAgency.business.implementation.ArticleBLL;
import com.NewsAgency.persistence.entity.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class Requester {
	
	@Autowired 
	private ArticleBLL articleBLL;
	
	@Autowired
	private WriterBLLInterface writerBLL;
	
	private ObjectMapper objectMapper;
	private Writer loggedInUser;
	
	
	public Requester()
	{
		objectMapper= new ObjectMapper();
	}
	
	public List<Article> viewArticles()
	{	
		List<Article> articles = this.articleBLL.getAll();	
		return articles;
	}

	public void saveArticle(String requestString) throws JsonParseException, JsonMappingException, IOException {
		ArticleSaveRequest articleSaveRequest= this.objectMapper.readValue(requestString, ArticleSaveRequest.class);
		Article article= articleSaveRequest.getArticleToSave();
		article.setId(findSize());
		articleBLL.saveArticle(article);
		
	}
	
	
	public void deleteArticle(String requestString) throws JsonParseException, JsonMappingException, IOException {
		ArticleDeleteRequest articleDeleteRequest=this.objectMapper.readValue(requestString, ArticleDeleteRequest.class);
		Integer id= articleDeleteRequest.getDeleteId();
		articleBLL.deleteArticle(id);
		
	}
	
	public boolean login(String requestString) throws JsonParseException, JsonMappingException, IOException
	{
		LoginRequest request = objectMapper.readValue(requestString, LoginRequest.class);
		this.loggedInUser=this.writerBLL.findByEmail(request.getEmailLogin());
		return this.writerBLL.login(request.getEmailLogin(), request.getPassword());
	}
	
	private Integer findSize()
	{
		int nr = 1;
		int size= this.articleBLL.getAll().size();
		int index= this.articleBLL.getAll().get(size-1).getId();
		nr+= index;
		return nr;
	}

	public ArticleBLL getArticleBLL() {
		return articleBLL;
	}

	public Writer getLoggedInUser() {
		return loggedInUser;
	}

	


	

	
	

}
