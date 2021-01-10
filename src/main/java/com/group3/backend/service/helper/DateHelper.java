package com.group3.backend.service.helper;

import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	public static Date getMidnightXDaysInAdvance(int daysInAdvance) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DAY_OF_YEAR, daysInAdvance);
		return cal.getTime();
	}
}
