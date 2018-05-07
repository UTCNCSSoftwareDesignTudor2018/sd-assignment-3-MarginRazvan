package com.NewsAgency.communication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientHandler implements Runnable {

	private Socket socket;
	
	private PrintWriter out;
	private BufferedReader in;
	
	public ClientHandler()
	{
		
	}
	
	
	
	
	public ClientHandler(Socket socket) {
		super();
		this.socket = socket;
		System.out.println("connection on "+socket);
		
		try {
			
			this.out = new PrintWriter(socket.getOutputStream(),true);
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}




	@Override
	public void run() {
		
		while (true)
		{
			
			
		}
		// TODO Auto-generated method stub
		
	}

}
