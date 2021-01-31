package com.group3.backend;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.group3.backend.ui.model.request.MedicationDetailsModel;
import com.group3.backend.ui.model.response.MedicationDetailsRepository;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	private MedicationDetailsRepository medicationDetailsRepo;
	
	
	@Test
	public void getAllMedicationDetails()
	{
		List<MedicationDetailsModel> getAllMedicationDetails = medicationDetailsRepo.findAll();
		
		assert(getAllMedicationDetails).size() > 0;
	}

}
