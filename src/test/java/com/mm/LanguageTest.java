package com.mm;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mm.languages.CS_CZ;
import com.mm.languages.EN_GB;
import com.mm.languages.EN_US;
import com.mm.languages.ES_ES;
import com.mm.languages.LanguageProducer;

public class LanguageTest {

    private HashMap<String, String> map = new HashMap<>();

    @BeforeEach
    public void prepare() {
        map.put("cs_CZ", "Dobre Odpoledne");
        map.put("en_US", "Good Afternoon");
        map.put("en_GB", "Good Afternoon");
        map.put("es_ES", "Buenas Tardes");
    }

    @Test
    public void testLangProducer() {

        try {

            for (String key : map.keySet()) { 
                LanguageProducer lp = new LanguageProducer(key);
                assertTrue(lp.findLang().afternoon().contentEquals(map.get(key)));
            }

        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testES_ES() {
        ES_ES es = new ES_ES();
        assertTrue(es.afternoon().equals("Buenas Tardes"));
        assertTrue(es.morning().equals("Buenos Dias"));
        assertTrue(es.evening().equals("Buena Noches"));
        assertTrue(es.general().equals("Buenos Dias"));

    }

    @Test
    public void testEN_GB() {
        EN_GB es = new EN_GB();
        assertTrue(es.afternoon().equals("Good Afternoon"));
        assertTrue(es.morning().equals("Good Morning"));
        assertTrue(es.evening().equals("Good Evening"));
        assertTrue(es.general().equals("Hello"));

    }

    @Test
    public void testEN_US() {
        EN_US es = new EN_US();
        assertTrue(es.afternoon().equals("Good Afternoon"));
        assertTrue(es.morning().equals("Good Morning"));
        assertTrue(es.evening().equals("Good Evening"));
        assertTrue(es.general().equals("Hello"));

    }

    @Test
    public void testCS_CZ() {
        CS_CZ es = new CS_CZ();
        assertTrue(es.afternoon().equals("Dobre Odpoledne"));
        assertTrue(es.morning().equals("Dobre Rano"));
        assertTrue(es.evening().equals("Dobry Vecer"));
        assertTrue(es.general().equals("Ahoj"));

    }

}
