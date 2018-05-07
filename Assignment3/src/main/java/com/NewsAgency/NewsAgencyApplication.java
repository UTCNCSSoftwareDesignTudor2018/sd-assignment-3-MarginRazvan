package com.NewsAgency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.NewsAgency.communication.ServerHandler;

@SpringBootApplication
public class NewsAgencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsAgencyApplication.class, args);
		
	}
	
	@Bean
	public ServerHandler startServer()
	{
		return new ServerHandler();
	}
	
}
