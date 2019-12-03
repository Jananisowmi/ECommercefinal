package com.hcl.ecommerce.exception;

import org.springframework.stereotype.Component;

@Component
public class ErrorResponse {
	
	

	public ErrorResponse(String message) {
		
	}
	
	

	public ErrorResponse() {
		super();
	}



	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
