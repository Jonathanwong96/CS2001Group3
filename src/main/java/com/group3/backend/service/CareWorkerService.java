package com.group3.backend.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import com.group3.backend.ui.model.request.CareWorkerRequest;
import com.group3.backend.ui.model.response.CareWorkerResponse;


public interface CareWorkerService {
	CareWorkerResponse createCareWorker(CareWorkerRequest CareWorkerRequest);
	CareWorkerResponse editCareWorker(CareWorkerRequest CareWorkerRequest);
    ArrayList<CareWorkerResponse> getAllCareWorkersForHome(long careHomeId);
    CareWorkerResponse getCareWorker(long CareWorkerId);
	Object deleteCareWorker(long careWorkerId) throws SQLIntegrityConstraintViolationException;
}