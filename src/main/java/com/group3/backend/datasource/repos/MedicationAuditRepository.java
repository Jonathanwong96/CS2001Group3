package com.group3.backend.datasource.repos;

//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//import com.group3.backend.datasource.entity.MedicationAuditEntity;
import com.group3.backend.datasource.entity.MedicationCountEntity;


@Repository
public interface MedicationAuditRepository extends CrudRepository<MedicationCountEntity, Long> {

    Iterable<MedicationCountEntity> findAll();
    List<MedicationCountEntity> findAllByMedCountId (long medCountId);

    

//		List<MedicationAuditEntity> findAllByName(long name);
//	    Optional <MedicationAuditEntity> findById(long id);

}
