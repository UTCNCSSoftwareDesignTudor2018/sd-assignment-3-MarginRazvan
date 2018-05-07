package com.NewsAgency.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.NewsAgency.persistence.entity.Article;

@Service
public interface ArticleBLLInterface {
	
	public List<Article> findAll();
	
	
	public void deleteArticle(Integer id);
	
	public void saveArticle(Article article);

	Optional<Article> findById(Integer id);

}
