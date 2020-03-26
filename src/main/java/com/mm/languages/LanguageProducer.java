package com.mm.languages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mm.GreetingException;

/**
 * 
 * How to add new Language:
 *  1. create new class e.g. sk_SK
 *  2. add class to SUPPORTED_LANGUAGES array at he begining of this file 
 *  3. done
 * 
 * @author marian
 *
 */
public class LanguageProducer {

    private final Logger logger = LoggerFactory.getLogger(LanguageProducer.class);
    
    private String lang;
    private static final Class[] SUPPORTED_LANGUAGES = new Class[] {
            EN_GB.class, 
            EN_US.class,
            CS_CZ.class,
            ES_ES.class};
       
    public LanguageProducer(String lang) {
        this.lang = lang;
    }
    
    public Language findLang() throws GreetingException, Exception{
        
        for (int i = 0; i < SUPPORTED_LANGUAGES.length; i++) {
              if(lang.equalsIgnoreCase(SUPPORTED_LANGUAGES[i].getSimpleName())) {
                   try {
                      return (Language)SUPPORTED_LANGUAGES[i].getConstructor().newInstance();
                   }catch (Exception e) {
                       logger.error(e.getMessage());
                       throw new Exception(e.getMessage());
                   }
              }
        }
       
        final String msg = "Unsuported language: "+lang;
        logger.error(msg);
        throw new GreetingException(msg);
    
    }
    
}
