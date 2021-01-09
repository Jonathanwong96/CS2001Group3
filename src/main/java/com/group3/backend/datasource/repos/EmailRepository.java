package com.group3.backend.datasource.repos;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group3.backend.datasource.entity.EmailEntity;


@Repository
public interface EmailRepository extends CrudRepository<EmailEntity, Long> {
	EmailEntity findByNonGuessableId(String nonGuessableId);
	ArrayList<EmailEntity> findAllByCareHomeName(String careHomeName);
	ArrayList<EmailEntity> findAllByDateMedicationToBeReady(Date date);
}
