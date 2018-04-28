package com.NewsAgency.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NewsAgency.persistence.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
