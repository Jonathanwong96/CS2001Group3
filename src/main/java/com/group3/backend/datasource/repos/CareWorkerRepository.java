package com.group3.backend.datasource.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group3.backend.datasource.entity.CareWorkerEntity;

@Repository
public interface CareWorkerRepository extends CrudRepository<CareWorkerEntity, Long> {
}
