package com.mm;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.mm.Timer.DayPeriod;

public class GreetingServiceTest {

    
      @Test
      public void sensitiveGreetingTest() {
          GreetingService gs  =  new GreetingService();
          GreetingEntityResp resp = gs.greetingSensitive("es_ES");
          
          DayPeriod dayPeriod = Timer.getDayPeriod();
          if (dayPeriod == DayPeriod.MORNING) {
              assertTrue(resp.getGreeting().equals("Buenos Dias"));
          }
          if (dayPeriod == DayPeriod.AFTERNOON) {
              assertTrue(resp.getGreeting().equals("Buenas Tardes"));
          }
          if (dayPeriod == DayPeriod.EVENING) {
              assertTrue(resp.getGreeting().equals("Buena Noches"));
          }
          if (dayPeriod == DayPeriod.GENERAL) {
              assertTrue(resp.getGreeting().equals("Buenos Dias"));
          }

      }
      
      @Test
      public void insensitiveGreetingTest() {
          GreetingService gs  =  new GreetingService();
          GreetingEntityResp resp = gs.greetingInsensitive("es_ES");
          
          DayPeriod dayPeriod = Timer.getDayPeriod();
          assertTrue(resp.getGreeting().equals("Buenos Dias"));
          

      }
      
      @Test
      public void testErrorSensitive() {
          
          try {
              GreetingService gs  =  new GreetingService();
              GreetingEntityResp resp = gs.greetingInsensitive("es_ESasdasd");
              
              DayPeriod dayPeriod = Timer.getDayPeriod();  
          }catch (Exception e) {
             assertTrue(e.getMessage().contains("Unsuported"));
        }
      }
    
}
