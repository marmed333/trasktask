package com.mm;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Greeting custom exception handling
 * @author marian
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GreetingException extends RuntimeException {
    
    public GreetingException() {
        super();
    }
    public GreetingException(String message, Throwable cause) {
        super(message, cause);
    }
    public GreetingException(String message) {
        super(message);
    }
    public GreetingException(Throwable cause) {
        super(cause);
    }

}
