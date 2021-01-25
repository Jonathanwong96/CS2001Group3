package com.group3.backend.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.group3.backend.ui.model.request.ResidentRequest;
import com.group3.backend.ui.model.response.ResidentResponse;

public interface ResidentService {
	ResidentResponse createResident(ResidentRequest residentRequest);
    ResidentResponse editResident(ResidentRequest residentRequest);
    ArrayList<ResidentResponse> getAllResidentsForHome(long careHomeId);
}