package com.NewsAgency.communication.handlers;

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
	public String getPassword() {
		return password;
	}
}
