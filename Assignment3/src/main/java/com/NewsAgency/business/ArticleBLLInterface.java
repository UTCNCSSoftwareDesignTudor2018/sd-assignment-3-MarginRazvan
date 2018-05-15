package com.NewsAgency.business;

import java.util.List;
import java.util.Observer;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.NewsAgency.persistence.entity.Article;


public interface ArticleBLLInterface {
	
	public List<Article> getAll();
	
	
	public void deleteArticle(Integer id);
	
	public void saveArticle(Article article);


}
