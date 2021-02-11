package com.group3.backend.service;

import java.util.ArrayList;
import java.util.List;

import com.group3.backend.datasource.entity.MedicationCountEntity;


public interface MedicationCountService {
	MedicationCountEntity getMostRecentCount(List<MedicationCountEntity> allCounts);
}
