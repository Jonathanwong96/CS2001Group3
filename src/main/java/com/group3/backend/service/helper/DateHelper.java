package com.group3.backend.service.helper;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
//import java.time.ZoneOffset;
//import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	public static Date getStartOfDayXDaysInAdvance(int daysInAdvance) {
		LocalDate lDate = LocalDate.now();
		lDate = lDate.plusDays(daysInAdvance);
		return Date.from(lDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
	
    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
    
    public static int findDaysBetween(Date thisDate, Date thatDate) {
    	Date earliestDate = thisDate.before(thatDate) ? thisDate : thatDate;
    	Date latestDate = thisDate.before(thatDate) ? thatDate : thisDate;
    	
    	int daysBetween = -1;
    	do {
    		earliestDate = addDays(earliestDate, 1);
    		daysBetween++;
    	}
    	while (earliestDate.before(latestDate));
    	
    	return daysBetween;
    }
}
