package com.group3.backend.datasource.repos;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.group3.backend.datasource.entity.CareHomeEntity;

@Repository
public interface CareHomeRepository extends CrudRepository<CareHomeEntity, Long> {

}