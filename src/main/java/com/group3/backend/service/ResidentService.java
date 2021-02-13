package com.group3.backend.service;

import java.util.ArrayList;

import com.group3.backend.ui.model.request.ResidentRequest;
import com.group3.backend.ui.model.response.ResidentResponse;

public interface ResidentService {
	ResidentResponse createResident(ResidentRequest residentRequest);
    ResidentResponse editResident(ResidentRequest residentRequest);
    ArrayList<ResidentResponse> getAllResidentsForHome(long careHomeId);
    ResidentResponse getResident(long residentId);
}