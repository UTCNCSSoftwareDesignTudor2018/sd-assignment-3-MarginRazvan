package com.NewsAgency.communication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHandler implements Runnable {

	public ServerHandler()
	{
		this.run();
	}
	
	
	
	
	@Override
	public void run() {
		ServerSocket server;
		
		try {
			server = new ServerSocket(1111);
			System.out.println("Server started and waiting for connections");
			
			
			try {
				while(true)
				{
					new ClientHandler(server.accept()).run();
				}
				
			} finally {
				server.close();
				// TODO: handle finally clause
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		
	}

}
