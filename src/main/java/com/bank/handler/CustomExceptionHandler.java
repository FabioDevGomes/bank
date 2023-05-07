package com.bank.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

	
//@ControllerAdvice
//@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
		
//	@ExceptionHandler(BadRequest.class)
//	public final ResponseEntity<?> handlerAllExceptions(Exception ex, WebRequest request){
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Varifique os dados de entrada");
//	}
		
}

