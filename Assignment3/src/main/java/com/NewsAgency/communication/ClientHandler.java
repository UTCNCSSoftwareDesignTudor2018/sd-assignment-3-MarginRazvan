package com.NewsAgency.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;

import com.NewsAgency.business.WriterBLLInterface;
import com.NewsAgency.business.implementation.WriterBLL;
import com.NewsAgency.business.util.SpringAplicationContext;
import com.NewsAgency.communication.handlers.LoginRequest;
import com.NewsAgency.communication.handlers.LoginResponse;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ClientHandler implements Runnable {

	private Socket socket;
	
	private PrintWriter out;
	private BufferedReader in;
	
	private ObjectMapper objectMapper;
	
	
	private WriterBLLInterface writerBLL= SpringAplicationContext.getBean(WriterBLLInterface.class);
	
	public ClientHandler()
	{
		
	}
	
	
	
	
	public ClientHandler(Socket socket) {
		super();
		this.socket = socket;
		this.objectMapper= new ObjectMapper();
		System.out.println("connection on "+this.socket);
		//this.writerBLL= new WriterBLL();
		
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

			try {
				String requestString;
				requestString = this.in.readLine();
				
				System.out.println(requestString);
				
				if (requestString.contains("email"))
				{
					LoginRequest request = objectMapper.readValue(requestString, LoginRequest.class);
					boolean success = this.writerBLL.login(request.getEmail(), request.getPassword());
					
					LoginResponse response = new LoginResponse();
					
					if (success)
					{
						response.setResponse("success");
					}else
					{
						response.setResponse("false");
					}
					
					out.println(objectMapper.writeValueAsString(response));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
			
			
		// TODO Auto-generated method stub
		
	}

}
