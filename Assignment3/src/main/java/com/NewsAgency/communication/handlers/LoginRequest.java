package com.NewsAgency.communication.handlers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest {
	
	private String emailLogin;
	private String password;
	
	
	public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginRequest(String emailLogin, String password) {
		super();
		this.emailLogin = emailLogin;
		this.password = password;
	}
	
	
	
	
	public String getEmailLogin() {
		return emailLogin;
	}
	public void setEmailLogin(String emailLogin) {
		this.emailLogin = emailLogin;
	}
	public String getPassword() {
		return password;
	}
	
	
	
	

}
