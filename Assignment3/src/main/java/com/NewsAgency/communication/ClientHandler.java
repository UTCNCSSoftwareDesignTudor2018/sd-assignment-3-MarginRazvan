package com.NewsAgency.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.NewsAgency.business.ArticleBLLInterface;
import com.NewsAgency.business.WriterBLLInterface;
import com.NewsAgency.business.implementation.ArticleBLL;
import com.NewsAgency.business.implementation.WriterBLL;
import com.NewsAgency.business.util.SpringAplicationContext;
import com.NewsAgency.communication.handlers.ArticleSaveRequest;
import com.NewsAgency.communication.handlers.LoginRequest;
import com.NewsAgency.communication.handlers.LoginResponse;
import com.NewsAgency.communication.handlers.Requester;
import com.NewsAgency.communication.handlers.Responder;
import com.NewsAgency.communication.handlers.ViewArticlesResponse;
import com.NewsAgency.persistence.entity.Article;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientHandler implements Runnable,Observer {

	private Socket socket;
	
	private PrintWriter out;
	private BufferedReader in;
	
	private ObjectMapper objectMapper;
	
	private Requester requester;
	private Responder responder;
	
	
	
	
	public ClientHandler(Socket socket) {
		super();
		
		this.requester= SpringAplicationContext.getBean(Requester.class);
		this.responder= SpringAplicationContext.getBean(Responder.class);
		this.socket = socket;
		this.objectMapper= new ObjectMapper();
		this.requester.getArticleBLL().addObserver(this);
		System.out.println("connection on "+this.socket);
		
		try {
			
			this.out = new PrintWriter(socket.getOutputStream(),true);
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}




	@Override
	public void run() {
		while (true)
		{

			try {
				String requestString;
				requestString = this.in.readLine();
				
				System.out.println(requestString);
				
				if (requestString.contains("emailLogin"))
				{
					
					boolean success=requester.login(requestString);
					
					LoginResponse response=responder.getLoginResponse(requester.getLoggedInUser(), success);
					out.println(objectMapper.writeValueAsString(response));
				}
				
				if (requestString.contains("getArticles"))
				{
					List<Article> articles = requester.viewArticles();
					ViewArticlesResponse response = responder.getViewArticlesResponse(articles);
					out.println(objectMapper.writeValueAsString(response));
				}
				
				if (requestString.contains("articleToSave"))
				{
					requester.saveArticle(requestString);
				}
				
				if (requestString.contains("deleteId"))
				{
					requester.deleteArticle(requestString);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
			
			
		// TODO Auto-generated method stub
		
	}




	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		try {
			System.out.println("SERVER Si o dat seama ca s o facut modificari");
			List<Article> articles = requester.viewArticles();
			ViewArticlesResponse response = responder.getViewArticlesResponse(articles);
			out.println(objectMapper.writeValueAsString(response));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
