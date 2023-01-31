package com.ngo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ngo.payloads.ApiResponse;

@RestControllerAdvice //
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		
		 String message = ex.getMessage();
		 
		 ApiResponse api=new ApiResponse(message, false);
		
		return null;
		
	}

}
 