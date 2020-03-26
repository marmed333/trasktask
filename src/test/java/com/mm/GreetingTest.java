package com.mm;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.mm.Timer.DayPeriod;

public class GreetingTest {

    @Test
    public void testComputeMessageInSensitive() {
        try {
            Greeting greeting = new Greeting("en_US", GreetingType.TIME_INSENSITIVE);
            GreetingEntityResp resp = greeting.computeMessage();

            assertTrue(resp.getGreeting().equals("Hello"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testComputeMessageSensitive() {
        try {
            Greeting greeting = new Greeting("en_US", GreetingType.TIME_SENSITIVE);
            GreetingEntityResp resp = greeting.computeMessage();
            DayPeriod dayPeriod = Timer.getDayPeriod();

            if (dayPeriod == DayPeriod.MORNING) {
                assertTrue(resp.getGreeting().equals("Good Morning"));
            }
            if (dayPeriod == DayPeriod.AFTERNOON) {
                assertTrue(resp.getGreeting().equals("Good Afternoon"));
            }
            if (dayPeriod == DayPeriod.EVENING) {
                assertTrue(resp.getGreeting().equals("Good Evening"));
            }
            if (dayPeriod == DayPeriod.GENERAL) {
                assertTrue(resp.getGreeting().equals("Hello"));
            }

        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testError() {
        try {
            Greeting greeting = new Greeting("en_USs", GreetingType.TIME_SENSITIVE);
            greeting.computeMessage();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Unsuported language"));
        }
    }

}
