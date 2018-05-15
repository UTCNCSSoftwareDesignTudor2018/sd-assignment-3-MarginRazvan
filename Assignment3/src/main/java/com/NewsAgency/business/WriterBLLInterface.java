package com.NewsAgency.business;

import org.springframework.stereotype.Service;

import com.NewsAgency.persistence.entity.Article;
import com.NewsAgency.persistence.entity.Writer;

@Service
public interface WriterBLLInterface {

	
	public boolean login(String username,String password);
	
	public void saveArticle(Article article);
	
	public void deleteArticle(Integer id);
	
	public Writer findByEmail(String email);
	
	
}
