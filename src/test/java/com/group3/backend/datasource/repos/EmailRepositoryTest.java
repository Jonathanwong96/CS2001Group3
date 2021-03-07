package com.group3.backend.datasource.repos;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.annotation.Propagation;

import com.group3.backend.datasource.entity.EmailEntity;
import com.group3.backend.service.helper.DateHelper;
import com.group3.backend.service.helper.EmailStatus;



@AutoConfigureTestDatabase(replace=Replace.NONE)
@DataJpaTest
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class EmailRepositoryTest {
	@Autowired TestEntityManager entityManager;
	@Autowired EmailRepository emailRepository;
	
	@Test
	void canGetOutAllNonCollectedMedicationRequests() {
		//test should get out all uncollected entities tomorrow or earlier
		
//		//Commented out as was made for old DB code. Will be updated soon - testing file uploads on remote server atm.
//		EmailEntity beforeCollected = new EmailEntity();
//		EmailEntity before = new EmailEntity();
//		EmailEntity dayAhead = new EmailEntity();
//		EmailEntity twoDaysAhead = new EmailEntity();
//		
//		beforeCollected.setStatus(EmailStatus.COMPLETED.getMessage());
//		beforeCollected.setDatePharmacySaysReady(DateHelper.getStartOfDayXDaysInAdvance(-2));
//		beforeCollected.setNonGuessableId("1");
//		before.setDatePharmacySaysReady(DateHelper.getStartOfDayXDaysInAdvance(-1));
//		before.setNonGuessableId("2");
//		dayAhead.setDatePharmacySaysReady(DateHelper.getStartOfDayXDaysInAdvance(1));
//		dayAhead.setNonGuessableId("3");
//		twoDaysAhead.setDatePharmacySaysReady(DateHelper.getStartOfDayXDaysInAdvance(2));
//		twoDaysAhead.setNonGuessableId("4");
//
//		emailRepository.save(beforeCollected);
//		emailRepository.save(before);
//		emailRepository.save(dayAhead);
//		emailRepository.save(twoDaysAhead);
//		
//		Date midnightTwoDaysAhead = DateHelper.getStartOfDayXDaysInAdvance(2);
//		ArrayList<EmailEntity> allUncollectedBeforeTwoDaysAhead = emailRepository.findAllReadyBy(midnightTwoDaysAhead);
//		
//		assertEquals(2, allUncollectedBeforeTwoDaysAhead.size());
//		for (EmailEntity emailEntity: allUncollectedBeforeTwoDaysAhead) {
//			Date medReadyDate = emailEntity.getDatePharmacySaysReady();
//			assertNotEquals(emailEntity.getStatus(), EmailStatus.COMPLETED.getMessage());
//			assertTrue(medReadyDate.equals(before.getDatePharmacySaysReady()) 
//					|| medReadyDate.equals(dayAhead.getDatePharmacySaysReady()));
//		}
	}
}
