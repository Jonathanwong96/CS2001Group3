package com.group3.backend.datasource.repos;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.group3.backend.datasource.entity.MedicationCountEntity;


@Repository
public interface MedicationAuditRepository extends CrudRepository<MedicationCountEntity, Long> {

    Iterable<MedicationCountEntity> findAll();


//		List<MedicationAuditEntity> findAllByName(long name);
//	    Optional <MedicationAuditEntity> findById(long id);

}
