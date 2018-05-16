package com.NewsAgency.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.NewsAgency.communication.Client;
import com.NewsAgency.presentation.view.LoginView;



public class LoginController {
	
	private LoginView loginView;
	private Client client;
	public LoginController(Client client)
	{
		this.loginView=new LoginView();
		this.client=client;
		new Thread(this.client).start();
		loginView.setVisible(true);
		this.addReaderoginListener();
		this.addWriterLoginListener();
	}

	private void addWriterLoginListener() {
		
		loginView.addLoginWriterButton(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String email=loginView.getEmail();
				String pass=loginView.getPassword();
				

				String status=client.getClientStatus();
				
				client.sendLoginRequest(email, pass);
				while (client.getClientStatus().equals(status))
				{
					System.out.print("");
				}
				if (client.getClientStatus().equals("OK"))
				{
					
					WriterController writerController= new WriterController(client,client.getWriter());
					loginView.setVisible(false);
				}
				else if (client.getClientStatus().equals("Invalid Data"))
				{
					loginView.showErrorMessage("Invalid Data");
				}
				
				client.setClientStatus("Undefined");
				
			}
		});
		
	}

	private void addReaderoginListener() {
		// TODO Auto-generated method stub
		loginView.addLoginReaderButton(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ReaderController readerController= new ReaderController(client);
				loginView.setVisible(false);
				
			}
		});
	}
	
	
	

}