package com.group3.backend.service;

import java.util.ArrayList;
import java.util.List;

import com.group3.backend.datasource.entity.MedicationCountEntity;
import com.group3.backend.ui.model.request.MedicationCountRequest;
import com.group3.backend.ui.model.response.MedicationCountResponse;


public interface MedicationCountService {
	MedicationCountEntity getMostRecentCount(List<MedicationCountEntity> allCounts);
	MedicationCountResponse addCount(MedicationCountRequest medicationCountRequest);
	ArrayList<MedicationCountResponse> getCountsForResident(long resId);
}
