package com.NewsAgency.communication.handlers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest {
	
	private String email;
	private String password;
	
	
	public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
	
	
	

}
