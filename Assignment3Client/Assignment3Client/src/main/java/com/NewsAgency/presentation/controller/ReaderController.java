package com.NewsAgency.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.table.DefaultTableModel;

import com.NewsAgency.communication.Client;
import com.NewsAgency.presentation.view.ArticleView;
import com.NewsAgency.presentation.view.ReaderView;
import com.NewsAgency.entity.*;
public class ReaderController implements Observer {
	
	private Client client;
	private ReaderView readerView;
	
	public ReaderController(Client client)
	{
		this.client=client;

		this.readerView= new ReaderView();
		client.addObserver(this);
		this.addButtonListener();
		
		
		this.sendViewArticlesRequest();
		this.readerView.setVisible(true);
		
	}
	

	
	
	private void updateTable(List<Article> articles) {
		// TODO Auto-generated method stub
		DefaultTableModel tableModel = new DefaultTableModel();
		
		tableModel.addColumn("Id");
		tableModel.addColumn("Title");
		tableModel.addColumn("Abstract");
		tableModel.addColumn("Writer");
		
		for (Article a:articles)
			tableModel.addRow(new String[]{a.getId().toString(),a.getTitle(),a.getArticleAbstract(),a.getWriter().getName()});
		
		readerView.updateTable(tableModel);
		
	}


	public void addButtonListener()
	{
		readerView.addViewArticleListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id=readerView.getArticleId();
				
				if (!readerView.getArticleId().equals(""))
				{
					Article article = client.getArticle(Integer.parseInt(id));
					if (article!=null)
					{
						System.out.println(article.toString());
						ArticleView articleView = new ArticleView(article);
						articleView.setVisible(true);
					}else readerView.showErrorMessage("Invalid Data");
				}else readerView.showErrorMessage("Invalid Data");
			}
		});
	}
	
	private void sendViewArticlesRequest()
	{
		boolean status=client.isArticlesChanged();
		client.sendViewArticlesRequest();
		while(client.isArticlesChanged()==status)
		{
			System.out.print("");
		}
		this.updateTable(client.getArticles());
	}

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.updateTable((List<Article>) arg);
		
	}
	

}
