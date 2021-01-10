package com.group3.backend.service.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

public class DateHelperTest {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	
	@Test
	void canGetMidnightToday() {
		Date midnightToday = DateHelper.getMidnightXDaysInAdvance(0);
		Date now = new Date();

		String midnightString = sdf.format(midnightToday);
		String nowString = sdf.format(now);
		
		assertEquals(nowString.split(" ")[0], midnightString.split(" ")[0]);
		assertEquals(nowString.split(" ")[1], "00:00:00");
	}
	
	@Test
	void canAddDays() {
		int daysToAdd = 35;
		
		Date futureDate = DateHelper.getMidnightXDaysInAdvance(daysToAdd);
		Date now = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(now);
		calendar.add(Calendar.DATE, daysToAdd);
		
		String futureDateString = sdf.format(futureDate);
		String datePart = futureDateString.split(" ")[0];
		String timePart = futureDateString.split(" ")[1];
		
		assertEquals(calendar.get(Calendar.YEAR), datePart.split("-")[0]);
		assertEquals(calendar.get(Calendar.MONTH), datePart.split("-")[1]);
		assertEquals(calendar.get(Calendar.DATE), datePart.split("-")[2]);
		
		assertEquals(calendar.get(Calendar.HOUR), timePart.split(":")[0]);
		assertEquals(calendar.get(Calendar.MINUTE), timePart.split(":")[1]);
		assertEquals(calendar.get(Calendar.SECOND), timePart.split(":")[2]);
	}
	
	@Test
	void canSubtractDays() {
		int daysToAdd= -35;
		
		Date futureDate = DateHelper.getMidnightXDaysInAdvance(daysToAdd);
		Date now = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(now);
		calendar.add(Calendar.DATE, daysToAdd);
		
		String futureDateString = sdf.format(futureDate);
		String datePart = futureDateString.split(" ")[0];
		String timePart = futureDateString.split(" ")[1];
		
		assertEquals(calendar.get(Calendar.YEAR), datePart.split("-")[0]);
		assertEquals(calendar.get(Calendar.MONTH), datePart.split("-")[1]);
		assertEquals(calendar.get(Calendar.DATE), datePart.split("-")[2]);
		
		assertEquals(calendar.get(Calendar.HOUR), timePart.split(":")[0]);
		assertEquals(calendar.get(Calendar.MINUTE), timePart.split(":")[1]);
		assertEquals(calendar.get(Calendar.SECOND), timePart.split(":")[2]);
	}

}
