package com.mm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mm.Timer.DayPeriod;
import com.mm.languages.Language;
import com.mm.languages.LanguageProducer;

/**
 * 
 * Main Greeting algo class
 * find a proper message for a supported language and day period
 * 
 * @author marian
 *
 */
public class Greeting {

    private final Logger logger = LoggerFactory.getLogger(Greeting.class);

    private GreetingType type;
    private String lang;

    public Greeting(String lang, GreetingType type) {
        this.lang = lang;
        this.type = type;
    }

    public GreetingEntityResp computeMessage() throws GreetingException, Exception{

        if (type == GreetingType.TIME_INSENSITIVE) {
            return new GreetingEntityResp(new LanguageProducer(lang).findLang().general());
        }

        if (type == GreetingType.TIME_SENSITIVE) {

            DayPeriod dayPeriod = Timer.getDayPeriod();

            LanguageProducer lProd = new LanguageProducer(lang);
            Language producedLang = lProd.findLang();

            if (dayPeriod == DayPeriod.MORNING) {
                return new GreetingEntityResp(producedLang.morning());
            }
            if (dayPeriod == DayPeriod.AFTERNOON) {
                return new GreetingEntityResp(producedLang.afternoon());
            }
            if (dayPeriod == DayPeriod.EVENING) {
                return new GreetingEntityResp(producedLang.evening());
            }

            return new GreetingEntityResp(producedLang.general());
        }

        final String msg = "time type not found supported: sensitive|insensitive";
        logger.error(msg);
        throw new GreetingException(msg);
    }

}
