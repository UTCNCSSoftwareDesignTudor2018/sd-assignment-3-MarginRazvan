package com.NewsAgency.business.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.NewsAgency.business.ArticleBLLInterface;
import com.NewsAgency.business.WriterBLLInterface;
import com.NewsAgency.business.util.SpringAplicationContext;
import com.NewsAgency.persistence.entity.Article;
import com.NewsAgency.persistence.entity.Writer;
import com.NewsAgency.persistence.repository.WriterRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class WriterBLL implements WriterBLLInterface {

	@Autowired
	private WriterRepository writerRepository;
	
	//@Autowired
	//private ArticleBLLInterface articleBLL;
	
	
	@Override
	public boolean login(String email, String password) {
		Writer writer = writerRepository.findByEmail(email);
		
		if (writer!=null)
		{
			if (writer.getPassword().equals(password))
			{
				return true;
			}else return false;

		}
		return false;
	}

	@Override
	public void saveArticle(Article article) {
		//articleBLL.saveArticle(article);
	}

	@Override
	public void deleteArticle(Integer id) {
		//articleBLL.deleteArticle(id);
	}
	
	

}
