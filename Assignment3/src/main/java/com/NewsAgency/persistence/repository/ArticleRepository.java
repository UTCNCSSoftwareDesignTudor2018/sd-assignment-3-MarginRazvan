package com.NewsAgency.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.NewsAgency.persistence.entity.Article;


public interface ArticleRepository extends JpaRepository<Article, Integer> {
	
	public List<Article> findByTitle(String title);
	
	public List<Article> findByArticleAbstract(String abstractt);
	
	public Optional<Article> findById(Integer id);

	public List<Article> findAll();


}
