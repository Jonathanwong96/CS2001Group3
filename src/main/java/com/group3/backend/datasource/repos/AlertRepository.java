package com.group3.backend.datasource.repos;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group3.backend.datasource.entity.AlertEntity;

@Repository
public interface AlertRepository extends JpaRepository<AlertEntity, Long> {
	ArrayList<AlertEntity> findAll();
}
