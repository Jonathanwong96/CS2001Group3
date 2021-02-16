package com.group3.backend.datasource.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group3.backend.datasource.entity.AutomaticEmailEntity;

@Repository
public interface AutomaticEmailRepository extends CrudRepository<AutomaticEmailEntity, Long>  {
	
	AutomaticEmailEntity findByCareHomeId(long careHomeId);
	ArrayList<AutomaticEmailEntity> findAllByUsesAutomaticEmails(boolean usesAutomaticEmails);
}
