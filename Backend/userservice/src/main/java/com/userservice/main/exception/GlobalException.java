package com.userservice.main.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalException {
	
	private static final Logger log = LoggerFactory.getLogger(GlobalException.class); 
	
	@ExceptionHandler(Exception.class)
         public ResponseEntity<String> exceptionHandlerMethod2(Exception errmsg){
		
        log.error("Exception Occured : " + errmsg);
	
		return new ResponseEntity <>(errmsg.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);		
		
	}

}



