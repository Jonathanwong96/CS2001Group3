package com.group3.backend.datasource.repos;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group3.backend.datasource.entity.EmailEntity;
import com.group3.backend.service.helper.EmailStatus;

@Repository
public interface EmailRepository extends CrudRepository<EmailEntity, Long> {
	EmailEntity findByNonGuessableId(String nonGuessableId);
	@Query("SELECT e FROM email e WHERE e.status = 'Processing' AND e.datePharmacySaysReady < :date")
	ArrayList<EmailEntity> findAllReadyBy(@Param("date") Date date);
}