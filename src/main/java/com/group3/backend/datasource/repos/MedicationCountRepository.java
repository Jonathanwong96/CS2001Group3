package com.group3.backend.datasource.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import com.group3.backend.datasource.entity.MedicationCountEntity;

//using date 
@Repository
public interface MedicationCountRepository extends CrudRepository<MedicationCountEntity, Date> {

}
