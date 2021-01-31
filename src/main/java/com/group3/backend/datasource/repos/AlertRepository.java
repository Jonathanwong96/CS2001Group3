package com.group3.backend.datasource.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group3.backend.datasource.entity.AlertEntity;

@Repository
public interface AlertRepository extends CrudRepository<AlertEntity, Long> {

}
