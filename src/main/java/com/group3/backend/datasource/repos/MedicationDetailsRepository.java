package com.group3.backend.datasource.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group3.backend.datasource.entity.MedicationEntity;


@Repository
public interface MedicationDetailsRepository extends JpaRepository<MedicationEntity, Integer>{
	
    //List<MedicationEntity> findAll(); 

}


