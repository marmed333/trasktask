package com.mm;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 * Timer class, determines time period in day
 * supported are:
 *    05:00 / 11:59 - morning
 *    12:00 / 16.59 - afternoon
 *    17:00 / 21:59 - evenong
 *    22:00 / 04:58 - all others (general)
 *    
 *  Class does not consider time zones, it takes default one.  
 *   
 * @author marian
 *
 */
public class Timer {

    public static LocalTime _0500;
    public static LocalTime _1159;

    public static LocalTime _1200;
    public static LocalTime _1659;

    public static LocalTime _1700;
    public static LocalTime _2159;

    static {
        try {
            SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
            _0500 = parser.parse("05:00").toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
            _1159 = parser.parse("11:59").toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

            _1200 = parser.parse("12:00").toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
            _1659 = parser.parse("16:59").toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

            _1700 = parser.parse("17:00").toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
            _2159 = parser.parse("11:59").toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DayPeriod getDayPeriod() {

        LocalTime now = LocalTime.now(); 
        if (now.isAfter(_0500) && now.isBefore(_1159)) {
            return DayPeriod.MORNING;
        }else if (now.isAfter(_1200) && now.isBefore(_1659)) {
            return DayPeriod.AFTERNOON;
        }else if (now.isAfter(_1700) && now.isBefore(_2159)) {
            return DayPeriod.EVENING;
        }
        
        return DayPeriod.GENERAL;

    }

    public enum DayPeriod {
        MORNING, AFTERNOON, EVENING, GENERAL;
    }
}
