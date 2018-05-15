package com.NewsAgency.communication.handlers;

import com.NewsAgency.entity.Writer;

public class LoginResponse {

		
		private String response;
		private Writer writer;
		

		public LoginResponse(String response) {
			super();
			this.response = response;
		}

		public LoginResponse() {
			// TODO Auto-generated constructor stub
		}

		public String getResponse() {
			return response;
		}

		public void setResponse(String response) {
			this.response = response;
		}

		public Writer getWriter() {
			return writer;
		}

		public void setWriter(Writer writer) {
			this.writer = writer;
		}
		
		


}
