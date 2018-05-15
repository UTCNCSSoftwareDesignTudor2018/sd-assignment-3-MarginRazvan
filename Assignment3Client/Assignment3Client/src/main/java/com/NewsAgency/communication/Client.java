package com.NewsAgency.communication;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.NewsAgency.communication.handlers.ArticleDeleteRequest;
import com.NewsAgency.communication.handlers.ArticleSaveRequest;
import com.NewsAgency.communication.handlers.LoginRequest;
import com.NewsAgency.communication.handlers.LoginResponse;
import com.NewsAgency.communication.handlers.ViewArticlesRequest;
import com.NewsAgency.communication.handlers.ViewArticlesResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.NewsAgency.entity.*;
public class Client extends Observable implements Runnable{
	
	
	
	private Socket socket;
	
	private PrintWriter out;
	private BufferedReader in;
	
	private ObjectMapper objectMapper;
	
	private String clientStatus;
	private boolean articlesChanged;
	private List<Article> articles;
	private Writer writer;
	
	

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(Socket socket) {
		super();
		this.socket = socket;
		this.clientStatus="Undefined";
		articlesChanged = false;
		articles = new ArrayList<Article>();
		objectMapper = new ObjectMapper();
		try {
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.out= new PrintWriter(socket.getOutputStream(),true);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void sendLoginRequest(String email,String password)
	{
		
		LoginRequest request = new LoginRequest(email, password);
		try {
			System.out.println(request.toString());
			this.out.println(objectMapper.writeValueAsString(request));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendViewArticlesRequest()
	{
		ViewArticlesRequest request = new ViewArticlesRequest();
		System.out.println(request.toString());
		try {
			this.out.println(objectMapper.writeValueAsString(request));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveArticleRequest(Article article)
	{
		ArticleSaveRequest request= new ArticleSaveRequest(article);
		System.out.println(request.toString());
		
		try {
			this.out.println(objectMapper.writeValueAsString(request));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public void deleteArticleRequest(Integer id) {
		// TODO Auto-generated method stub
		ArticleDeleteRequest articleDeleteRequest= new ArticleDeleteRequest(id);
		try {
			this.out.println(objectMapper.writeValueAsString(articleDeleteRequest));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	public void run() {
		// TODO Auto-generated method stub
		
		try {
			
			while (true)
			{
				String responseString = this.in.readLine();
				System.out.println(responseString);

				
				if (responseString.contains("response"))
				{
					LoginResponse response = objectMapper.readValue(responseString, LoginResponse.class);
					System.out.println(clientStatus);
					System.out.println(response.getResponse());
					if (response.getResponse().equals("success"))
					{
						this.clientStatus = "OK";
						this.writer= response.getWriter();
					}
					else
					{
						this.clientStatus = "Invalid Data";
					}
				}
				
				if (responseString.contains("articles"))
				{
					ViewArticlesResponse response = objectMapper.readValue(responseString, ViewArticlesResponse.class);
					setArticles(response.getArticles());
					setArticlesChanged(true);
				}
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public String getClientStatus() {
		return clientStatus;
	}

	public Writer getWriter() {
		return writer;
	}

	public void setClientStatus(String clientStatus) {
		this.clientStatus = clientStatus;
	}

	public boolean isArticlesChanged() {
		return articlesChanged;
	}

	public void setArticlesChanged(boolean clientsChanged) {
		this.articlesChanged = clientsChanged;
	}

	public List<Article> getArticles() {
		return articles;
	}
	
	
	public void setArticles(List<Article> articles) {
		setChanged();
		this.articles = articles;
		notifyObservers(articles);
		clearChanged();
	}
	
	public Article getArticle(Integer id)
	{
		for (Article article: this.articles)
		{
			if (article.getId()==id)
			{
				return article;
			}
		}
		
		return null;
		
	}
}
