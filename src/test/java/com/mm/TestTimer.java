package com.mm;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.mm.Timer.DayPeriod;

public class TestTimer {
    
    
      @Test
      public void testDayPeriod() {
          LocalTime now = LocalTime.now();
          if (now.isAfter(Timer._0500) && now.isBefore(Timer._1159)) {
              assertTrue( Timer.getDayPeriod() == DayPeriod.MORNING ) ;
          }else if (now.isAfter(Timer._1200) && now.isBefore(Timer._1659)) {
              assertTrue( Timer.getDayPeriod() == DayPeriod.AFTERNOON ) ;
          }else if (now.isAfter(Timer._1700) && now.isBefore(Timer._2159)) {
              assertTrue( Timer.getDayPeriod() == DayPeriod.EVENING ) ;
          }else if (now.isAfter(Timer._2159) && now.isBefore(Timer._0500)) {
              assertTrue( Timer.getDayPeriod() == DayPeriod.GENERAL ) ;
          }
      }

}
