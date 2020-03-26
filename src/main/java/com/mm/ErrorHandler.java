package com.mm;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Handling of HTTP error and its message 
 * @author marian
 *
 */
@RestControllerAdvice
public class ErrorHandler {
 
    
    
    @ExceptionHandler(GreetingException.class) 
    public GreetingException handleCustomException(GreetingException ce) {
        return ce;
    }
    
    @ExceptionHandler(Exception.class) 
    public Exception handleCustomException(Exception ce) {
        return ce;
    }
 
}