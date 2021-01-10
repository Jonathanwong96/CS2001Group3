package com.group3.backend.datasource.repos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.group3.backend.datasource.entity.EmailEntity;
import com.group3.backend.service.helper.DateHelper;

@DataJpaTest
public class EmailRepositoryTest {
	@Autowired EmailRepository emailRepository;
	
	@Test
	void canGetOutAllNonCollectedMedicationRequests() {
		//test should get out all uncollected entities tomorrow or earlier
		EmailEntity beforeCollected = new EmailEntity();
		EmailEntity before = new EmailEntity();
		EmailEntity dayAhead = new EmailEntity();
		EmailEntity twoDaysAhead = new EmailEntity();
		
		beforeCollected.setCollected(true);
		beforeCollected.setDateMedicationToBeReady(DateHelper.getMidnightXDaysInAdvance(-2));
		before.setDateMedicationToBeReady(DateHelper.getMidnightXDaysInAdvance(-1));
		dayAhead.setDateMedicationToBeReady(DateHelper.getMidnightXDaysInAdvance(1));
		twoDaysAhead.setDateMedicationToBeReady(DateHelper.getMidnightXDaysInAdvance(2));

		emailRepository.saveAll(new ArrayList<EmailEntity>() {{add(beforeCollected); add(before); add(dayAhead); add(twoDaysAhead);}});
		
		Date midnightTwoDaysAhead = DateHelper.getMidnightXDaysInAdvance(2);
		ArrayList<EmailEntity> allUncollectedBeforeTwoDaysAhead = emailRepository.findAllUncollectedBy(midnightTwoDaysAhead);
		
		assertEquals(2, allUncollectedBeforeTwoDaysAhead.size());
		for (EmailEntity emailEntity: allUncollectedBeforeTwoDaysAhead) {
			Date medReadyDate = emailEntity.getDateMedicationToBeReady();
			assertFalse(emailEntity.isCollected());
			assertTrue(medReadyDate.equals(before.getDateMedicationToBeReady()) 
					|| medReadyDate.equals(dayAhead.getDateMedicationToBeReady()));
		}
	}
}
