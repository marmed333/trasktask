package com.mm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * Greeting service API.
 * takes two REST services
 * 1. greetingSensitive
 * 2. greetingInsensitive
 * 
 * param {lang}  is a supported language e.g. cs_CZ
 * 
 * 
 * @author marian
 *
 */
@SpringBootApplication
@RestController
public class GreetingService {

    @GetMapping(path = "/greetingSensitive/{lang}")
    public GreetingEntityResp greetingSensitive(@PathVariable String lang) throws GreetingException, ResponseStatusException{
        try {
            
            return new Greeting(lang, GreetingType.TIME_SENSITIVE).computeMessage();

        } catch (GreetingException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, e.getMessage(), e);
        }
    }

    @GetMapping(path = "/greetingInsensitive/{lang}") 
    public GreetingEntityResp greetingInsensitive(@PathVariable String lang) throws GreetingException, ResponseStatusException {
        try {

            return new Greeting(lang, GreetingType.TIME_INSENSITIVE).computeMessage();

        } catch (GreetingException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
 

     

    public static void main(String[] args) {
        SpringApplication.run(GreetingService.class, args);
    }

}
