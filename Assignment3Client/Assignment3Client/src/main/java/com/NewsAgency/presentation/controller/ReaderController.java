package com.NewsAgency.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.NewsAgency.communication.Client;
import com.NewsAgency.presentation.view.ReaderView;

public class ReaderController {
	
	private Client client;
	private ReaderView readerView;
	
	private ReaderController(Client client)
	{
		this.client=client;
		
		//this.readerView= new ReaderView();
		this.addButtonListener();
		this.readerView.setVisible(true);
		
	}
	
	
	public void addButtonListener()
	{
		readerView.addViewArticleListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
	}
	

}
