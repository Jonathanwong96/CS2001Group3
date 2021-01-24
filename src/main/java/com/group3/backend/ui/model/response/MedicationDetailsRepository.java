package com.group3.backend.ui.model.response;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group3.backend.ui.model.request.MedicationDetailsModel;

@Repository
public interface MedicationDetailsRepository extends JpaRepository<MedicationDetailsModel, Integer>{
	
    List<MedicationDetailsModel> findAll(); 

}
