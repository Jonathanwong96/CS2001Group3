package com.group3.backend.datasource.repos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.group3.backend.datasource.entity.EmailEntity;
import com.group3.backend.service.helper.DateHelper;



@AutoConfigureTestDatabase(replace=Replace.NONE)
@DataJpaTest
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class EmailRepositoryTest {
	@Autowired TestEntityManager entityManager;
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
		beforeCollected.setNonGuessableId("1");
		beforeCollected.setPharmacyEmail("abc@aol.com");
		before.setDateMedicationToBeReady(DateHelper.getMidnightXDaysInAdvance(-1));
		before.setNonGuessableId("2");
		before.setPharmacyEmail("123@aol.com");
		dayAhead.setDateMedicationToBeReady(DateHelper.getMidnightXDaysInAdvance(1));
		dayAhead.setNonGuessableId("3");
		dayAhead.setPharmacyEmail("llll@aol.com");
		twoDaysAhead.setDateMedicationToBeReady(DateHelper.getMidnightXDaysInAdvance(2));
		twoDaysAhead.setNonGuessableId("4");
		twoDaysAhead.setPharmacyEmail("99999@aol.com");

		emailRepository.save(beforeCollected);
		emailRepository.save(before);
		emailRepository.save(dayAhead);
		emailRepository.save(twoDaysAhead);
		
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
