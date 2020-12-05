package com.group3.backend.datasource.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group3.backend.datasource.entity.ResidentEntity;

@Repository
public interface ResidentRepository extends CrudRepository<ResidentEntity, Long> {
    List<ResidentEntity> findAllByCareHomeId(long careHomeId);
    List<ResidentEntity> findById(long residentId);
}
