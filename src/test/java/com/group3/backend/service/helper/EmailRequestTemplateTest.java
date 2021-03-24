package com.group3.backend.service.helper;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.group3.backend.ui.model.request.EmailRequest;

class EmailRequestTemplateTest {

	private EmailRequestTemplate emailReqTemplate = new EmailRequestTemplate();
	
	@Test
	void canSubstituteValuesCorrectly() {
		String nonGuessableId = "the-non-guessable-id";
		EmailRequest emailRequest = new EmailRequest("CAREHOME_NAME", "CAREHOME_EMAIL", "PHARMACY_EMAIL", "MEDICATION_NAME", "RESIDENT_NAME");
		Date today = new Date();
		emailRequest.setCycleEndDate(today);
		String email = emailReqTemplate.getSubstitutedTemplate(emailRequest, nonGuessableId);
		assertNotNull(email);
		assertTrue(email.contains("from CAREHOME_NAME"));
		assertTrue(email.contains("Hi there, this is from CAREHOME_EMAIL"));
		assertTrue(email.contains("running low on 'MEDICATION_NAME'"));
		assertTrue(email.contains("for RESIDENT_NAME"));
		
		//checking cycle end date
		String pattern = "dd-MM-yyyy";
    	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    	String expectedDate = sdf.format(today);
    	assertTrue(email.contains("Their current cycle ends on " + expectedDate));
    	
		//checking routes
		assertTrue(email.contains("/email/set-date?"+nonGuessableId));
		assertTrue(email.contains("/email/inquiry?"+nonGuessableId));
		
	}

}
