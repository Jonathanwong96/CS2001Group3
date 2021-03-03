package com.group3.backend.datasource.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group3.backend.datasource.entity.MedicationForResidentEntity;

@Repository
public interface MedicationForResidentRepository extends CrudRepository<MedicationForResidentEntity, Long> {
	ArrayList<MedicationForResidentEntity> findAllByResidentResidentId(long residentId); //name has to be like this for hibernate. TablenameFieldname. Would have looked nicer if each table's id field was just id rather than ResidentId.
}
