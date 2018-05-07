package com.NewsAgency.business.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NewsAgency.business.ArticleBLLInterface;
import com.NewsAgency.business.WriterBLLInterface;
import com.NewsAgency.persistence.entity.Article;
import com.NewsAgency.persistence.entity.Writer;
import com.NewsAgency.persistence.repository.WriterRepository;

@Service
public class WriterBLL implements WriterBLLInterface {

	@Autowired
	private WriterRepository writerRepository;
	
	@Autowired
	private ArticleBLLInterface articleBLL;
	
	
	@Override
	public boolean login(String username, String password) {
		
		Writer writer = writerRepository.findByEmail(username);
		
		if (!writer.equals(null)&&writer.getPassword().equals(password))
			return true;
		
		return false;
	}

	@Override
	public void saveArticle(Article article) {
		articleBLL.saveArticle(article);
		
	}

	@Override
	public void deleteArticle(Integer id) {
		articleBLL.deleteArticle(id);
	}
	
	

}
