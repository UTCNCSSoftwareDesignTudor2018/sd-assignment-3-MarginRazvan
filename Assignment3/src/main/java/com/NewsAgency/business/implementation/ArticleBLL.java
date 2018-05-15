package com.NewsAgency.business.implementation;

import java.util.List;
import java.util.Observable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.NewsAgency.business.ArticleBLLInterface;
import com.NewsAgency.persistence.entity.Article;
import com.NewsAgency.persistence.repository.ArticleRepository;
import com.NewsAgency.business.util.*;

@Service
public class ArticleBLL extends Observable implements ArticleBLLInterface {
	
	
	@Autowired
	private ArticleRepository articleRepository;

	@Override

	public List<Article> getAll() {
		return articleRepository.findAll();
	}


	@Override
	public void deleteArticle(Integer id) {
		// TODO Auto-generated method stub
		articleRepository.deleteById(id);
		notifyAllObservers();
		
		
	}

	@Override
	public void saveArticle(Article article) {
		
		// TODO Auto-generated method stub
		articleRepository.save(article);
		notifyAllObservers();
		
	}

	private synchronized void notifyAllObservers()
	{
		setChanged();
		notifyObservers();
		clearChanged();
		
	}
	

}
