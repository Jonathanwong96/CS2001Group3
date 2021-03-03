package com.group3.backend.datasource.repos;

import com.group3.backend.datasource.entity.PharmacyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//import java.util.List;

@Repository
public interface PharmacyRepository extends CrudRepository<PharmacyEntity, Long> {
	
}
