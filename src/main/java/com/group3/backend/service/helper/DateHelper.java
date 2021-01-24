package com.group3.backend.service.helper;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	public static Date getStartOfDayXDaysInAdvance(int daysInAdvance) {
		LocalDate lDate = LocalDate.now();
		lDate = lDate.plusDays(daysInAdvance);
		return Date.from(lDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
}
