package com.mm;

import javax.persistence.Entity;

/**
 * DAO class 
 * @author marian
 *
 */
@Entity
public class GreetingEntityResp {

    private String greeting;

    public GreetingEntityResp(String lang) {
        this.greeting = lang;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String toString() {
        return "GreetingEntityReq [lang=" + greeting + "]";
    }

}
