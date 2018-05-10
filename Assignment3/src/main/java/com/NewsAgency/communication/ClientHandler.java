package com.NewsAgency.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.NewsAgency.business.ArticleBLLInterface;
import com.NewsAgency.business.WriterBLLInterface;
import com.NewsAgency.business.implementation.ArticleBLL;
import com.NewsAgency.business.implementation.WriterBLL;
import com.NewsAgency.business.util.SpringAplicationContext;
import com.NewsAgency.communication.handlers.LoginRequest;
import com.NewsAgency.communication.handlers.LoginResponse;
import com.NewsAgency.communication.handlers.Requester;
import com.NewsAgency.communication.handlers.ViewArticlesResponse;
import com.NewsAgency.persistence.entity.Article;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientHandler implements Runnable {

	private Socket socket;
	
	private PrintWriter out;
	private BufferedReader in;
	
	private ObjectMapper objectMapper;
	
	//private ArticleBLLInterface articleBLL= SpringAplicationContext.getBean(ArticleBLLInterface.class);
	private WriterBLLInterface writerBLL;
	private Requester requester;
	
	
	
	
	public ClientHandler(Socket socket) {
		super();
		
		this.writerBLL= SpringAplicationContext.getBean(WriterBLLInterface.class);
		this.requester= SpringAplicationContext.getBean(Requester.class);
		this.socket = socket;
		this.objectMapper= new ObjectMapper();
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
				
				if (requestString.contains("email"))
				{
					LoginRequest request = objectMapper.readValue(requestString, LoginRequest.class);
					boolean success = this.writerBLL.login(request.getEmail(), request.getPassword());
					
					LoginResponse response = new LoginResponse();
					
					if (success)
					{
						response.setResponse("success");
					}else
					{
						response.setResponse("false");
					}
					
					out.println(objectMapper.writeValueAsString(response));
				}
				
				if (requestString.contains("getArticles"))
				{
				System.out.println("totu bine");
					List<Article> articles = requester.viewArticles(requestString);
					//ViewArticlesResponse response = new ViewArticlesResponse(this.articleBLL.findAll());
					//for (int i=0;i<response.getArticles().size();i++)
						//System.out.println(i+' '+response.getArticles().get(i).toString());
					//out.println(objectMapper.writeValueAsString(response));
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
			
			
		// TODO Auto-generated method stub
		
	}

}
