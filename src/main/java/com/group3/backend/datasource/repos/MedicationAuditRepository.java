package com.group3.backend.datasource.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import com.group3.backend.datasource.entity.MedicationCountEntity;


@Repository
public interface MedicationAuditRepository extends CrudRepository<MedicationCountEntity, Long> {

    Iterable<MedicationCountEntity> findAll();
    List<MedicationCountEntity> findAllByMedCountId (long medCountId);

//route to get count for past date
    List<MedicationCountEntity> findByCountDoneOnDate(@Param("countDoneOnDate") Date countDoneOnDate);

}
