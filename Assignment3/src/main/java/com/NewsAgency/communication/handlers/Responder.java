package com.NewsAgency.communication.handlers;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.NewsAgency.persistence.entity.Article;
import com.NewsAgency.persistence.entity.Writer;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Responder {
	
	private ObjectMapper objectMapper;
	private PrintWriter out;
	
	
	public Responder()
	{
		objectMapper=new ObjectMapper();
	}
	
	public LoginResponse getLoginResponse(Writer writer,boolean success)
	{
		LoginResponse response = new LoginResponse();
		
		if (success)
		{
			response.setResponse("success");
			response.setWriter(writer);
		}else
		{
			response.setResponse("false");
		}
		
		return response;
	}
	
	public ViewArticlesResponse getViewArticlesResponse(List<Article> articles)
	{
		return new ViewArticlesResponse(articles);
	}

}
