package com.NewsAgency.communication.handlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NewsAgency.business.ArticleBLLInterface;
import com.NewsAgency.persistence.entity.*;
@Service
public class Requester {
	
	@Autowired 
	ArticleBLLInterface articleBLL;
	
	public List<Article> viewArticles(String requestString)
	{
		System.out.println("incercam sa luam articolele");
		
		List<Article> articles = this.articleBLL.getAll();
		System.out.println("ni le o luat");
		
		for (int i=0;i<articles.size();i++)
		{
			System.out.println(i);
		}
		
		return articles;
	}

}
