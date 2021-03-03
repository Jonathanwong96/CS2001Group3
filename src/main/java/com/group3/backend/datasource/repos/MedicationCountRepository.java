package com.group3.backend.datasource.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
//import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import com.group3.backend.datasource.entity.MedicationCountEntity;

@Repository
public interface MedicationCountRepository extends CrudRepository<MedicationCountEntity, Date> {
	List<MedicationCountEntity> findAllByMedCountId (long medCountId);
	
	
//	Iterable<MedicationCountEntity> findAll();
//    List<MedicationCountEntity> findAllByMedCountId (long medCountId);
	
//    ArrayList<MedicationCountEntity> findAllMedicationAudits(long medCountId);
 //   List<MedicationCountEntity> findByDate(Date countDoneOnDate, long medCountId);
 //   List<MedicationAuditEntity> findAllByMedCountId (long medCountId);
}
