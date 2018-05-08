package com.NewsAgency.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.NewsAgency.communication.handlers.LoginRequest;
import com.NewsAgency.communication.handlers.LoginResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Client implements Runnable{
	
	
	
	private Socket socket;
	
	private PrintWriter out;
	private BufferedReader in;
	
	private ObjectMapper objectMapper;
	
	private String clientStatus;
	
	

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	





	public Client(Socket socket) {
		super();
		this.socket = socket;
		this.clientStatus="Undefined";
		objectMapper = new ObjectMapper();
		try {
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.out= new PrintWriter(socket.getOutputStream(),true);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void sendLoginRequest(String email,String password)
	{
		
		LoginRequest request = new LoginRequest(email, password);
		try {
			System.out.println(request.toString());
			this.out.println(objectMapper.writeValueAsString(request));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void run() {
		// TODO Auto-generated method stub
		
		try {
			
			while (true)
			{
				String responseString = this.in.readLine();
				System.out.println(responseString);

				
				if (responseString.contains("response"))
				{
					LoginResponse response = objectMapper.readValue(responseString, LoginResponse.class);
					System.out.println(clientStatus);
					System.out.println(response.getResponse());
					if (response.getResponse().equals("success"))
					{
						this.clientStatus = "OK";
					}
					else
					{
						this.clientStatus = "Invalid Data";
					}
					System.out.println(clientStatus);
				}
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public String getClientStatus() {
		return clientStatus;
	}







	public void setClientStatus(String clientStatus) {
		this.clientStatus = clientStatus;
	}
	
	

	
	
	
	

}
