package com.hcl.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=StoreNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(StoreNotFoundException exception) {
		ErrorResponse errorResponse=new ErrorResponse(exception.getMessage());
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		
	}

	@ExceptionHandler(value=UserNotPresentException.class)
	public ResponseEntity<ErrorResponse> handleException(UserNotPresentException exception) {
		ErrorResponse errorResponse=new ErrorResponse(exception.getMessage());
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value=UserOrderListException.class)
	public ResponseEntity<ErrorResponse> handleException(UserOrderListException exception) {
		ErrorResponse errorResponse=new ErrorResponse(exception.getMessage());
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		
	}
}
