package com.NewsAgency;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.NewsAgency.communication.Client;
import com.NewsAgency.presentation.controller.LoginController;

public class App 
{
    public static void main( String[] args )
    {
       try {
		Socket socket= new Socket("localhost", 1111);
		System.out.println(socket.getPort()+' '+socket.getLocalPort());
		Client client = new  Client(socket);
		

		LoginController controller = new LoginController(client);
		
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
}
