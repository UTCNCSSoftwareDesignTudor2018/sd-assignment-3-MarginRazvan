package com.NewsAgency.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.NewsAgency.communication.Client;
import com.NewsAgency.entity.Article;
import com.NewsAgency.entity.Writer;
import com.NewsAgency.presentation.view.WriterView;

public class WriterController {
	
	
	private WriterView writerView;
	private Client client;
	private Writer writer;
	
	public WriterController(Client client,Writer writer)
	{
		this.client=client;
		this.writer=writer;
		writerView = new WriterView();
		writerView.setLblWriter(writer.getName());
		this.addArticleListener();
		this.addDeleteListener();
		writerView.setVisible(true);
	}

	private void addDeleteListener() {
		// TODO Auto-generated method stub
		
		writerView.addDeleteButtonListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (writerView.getTextFieldId().equals(""))
				{
					writerView.showErrorMessage("Invalid Data");
				}
				else
				{
					client.deleteArticleRequest(Integer.parseInt(writerView.getTextFieldId()));
				}
				
			}
		});
		
	}

	private void addArticleListener() {
		// TODO Auto-generated method stub
		writerView.addButtonListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (writerView.getTextFieldTitle().equals("")||
						writerView.getTextAreaAbstract().equals("")||
						writerView.getTextAreaBody().equals(""))
				{
					writerView.showErrorMessage("Invalid Data");
				}else
				{
					Article article=new Article(writer,
							writerView.getTextFieldTitle(),writerView.getTextAreaAbstract()
							,writerView.getTextAreaBody());
					client.saveArticleRequest(article);
				}
			}
		});
		
	}
	
	
	
	
	
	

}
