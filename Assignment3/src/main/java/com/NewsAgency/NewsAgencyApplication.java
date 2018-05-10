package com.NewsAgency;

import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.NewsAgency.communication.ClientHandler;


@SpringBootApplication
public class NewsAgencyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication application= new SpringApplication(NewsAgencyApplication.class);
		application.run(args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket socket= new ServerSocket(1111);
		System.out.println("Started server and waiting for connections");
		try {
			
			while(true)
			{
				Socket clientSocket= socket.accept();
				ClientHandler clientHandler = new ClientHandler(clientSocket);
				
				new Thread(clientHandler).start();
			}
			
		} finally {
			// TODO: handle finally clause
			socket.close();
		}
	}
	
}
