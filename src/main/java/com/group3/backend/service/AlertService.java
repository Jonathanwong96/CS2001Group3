package com.group3.backend.service;

import java.util.ArrayList;

import com.group3.backend.ui.model.response.AlertResponse;

public interface AlertService {
	ArrayList<AlertResponse> getAllAlertsForCareHome(long careHomeId);
}
