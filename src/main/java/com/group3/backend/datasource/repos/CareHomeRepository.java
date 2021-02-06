package com.group3.backend.datasource.repos;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.group3.backend.datasource.entity.AutomaticEmailEntity;
import com.group3.backend.datasource.entity.CareHomeEntity;

@Repository
public interface CareHomeRepository extends CrudRepository<CareHomeEntity, Long> {
	ArrayList<AutomaticEmailEntity> findAllByUsesAutoEmail(boolean usesAutomaticEmail);
}