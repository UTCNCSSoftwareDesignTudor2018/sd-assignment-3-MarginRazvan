package com.NewsAgency.business.implementation;

import java.util.List;


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
public class ArticleBLL implements ArticleBLLInterface {
	
	
	@Autowired
	private ArticleRepository articleRepository;

	@Override

	public List<Article> getAll() {
		// TODO Auto-generated method stub
		System.out.println("o intrat in bll");
		//List<Article> articles = articleRepository.findByTitle("title1");
		//List<Article> articles = articleRepository.findAll();
		//if (articles==null)
		//{
		//	System.out.println("NU E BINE");
		//}
		System.out.println("Asdfasdfa");
		
		//System.out.println(articleRepository.findByArticleAbstract("abstract1").get(0).toString());
		//System.out.println("Asdfasdfa");
		//System.out.println(articles.get(0).toString());
		//System.out.println("Oare?");
		//System.out.println(articleRepository.findById(articles.get(0).getId()));
		//Optional<Article> art = articleRepository.findById(articles.get(0).getId());
		//System.out.println("Asdfasdfa");
		
		List<Article> da=articleRepository.findAll();
		System.out.println("NO");
		for (int i=0;i<da.size();i++)
		{
			System.out.println(da.get(i).toString());
		}
		return da;
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
