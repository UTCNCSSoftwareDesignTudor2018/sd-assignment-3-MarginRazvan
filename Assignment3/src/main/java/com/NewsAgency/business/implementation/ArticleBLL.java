package com.NewsAgency.business.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NewsAgency.business.ArticleBLLInterface;
import com.NewsAgency.persistence.entity.Article;
import com.NewsAgency.persistence.repository.ArticleRepository;

@Service
public class ArticleBLL implements ArticleBLLInterface {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public List<Article> findAll() {
		// TODO Auto-generated method stub
		return articleRepository.findAll();
	}

	@Override
	public Optional<Article> findById(Integer id) {
		// TODO Auto-generated method stub
		return articleRepository.findById(id);
	}

	@Override
	public void deleteArticle(Integer id) {
		// TODO Auto-generated method stub
		articleRepository.deleteById(id);
		
		
	}

	@Override
	public void saveArticle(Article article) {
		// TODO Auto-generated method stub
		articleRepository.save(article);
		
	}


	

}
