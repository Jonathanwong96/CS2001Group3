package com.group3.backend.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.group3.backend.datasource.entity.MedicationCountEntity;
import com.group3.backend.service.MedicationCount;

@Service
public class MedicationCountImpl implements MedicationCount {

	@Override
	public MedicationCountEntity getMostRecentCount(List<MedicationCountEntity> allCounts) {
		ArrayList<MedicationCountEntity> listCopy = new ArrayList<>(allCounts); //copying arraylist so we don't mutate argument
		Collections.sort(listCopy); //uses comparator on MedicationCountEntity
		return listCopy.get(0);
	}

}
