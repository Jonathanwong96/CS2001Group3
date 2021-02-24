package com.group3.backend.service.impl;
import com.group3.backend.datasource.entity.CareHomeEntity;
import com.group3.backend.datasource.entity.CareWorkerEntity;
import com.group3.backend.datasource.repos.CareHomeRepository;
import com.group3.backend.datasource.repos.CareWorkerRepository;
import com.group3.backend.service.CareWorkerService;
import com.group3.backend.service.helper.Utility;
import com.group3.backend.ui.model.request.CareWorkerRequest;
import com.group3.backend.ui.model.response.CareWorkerResponse;
import com.group3.backend.ui.model.response.ErrorMessages;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class CareWorkerServiceImpl implements CareWorkerService {
    @Autowired
    CareWorkerRepository careWorkerRepository;
    
    @Autowired 
    CareHomeRepository careHomeRepository;


    @Override
    public CareWorkerResponse createCareWorker(CareWorkerRequest careWorkerRequest) {
    	CareWorkerResponse toReturn = new CareWorkerResponse();
    	CareWorkerEntity careWorkerEntity = new CareWorkerEntity();
        BeanUtils.copyProperties(careWorkerRequest, careWorkerEntity);
        
        // dummy care home for local DB by id=7
    	Optional<CareHomeEntity> resp = careHomeRepository.findById((long) 7);
        CareHomeEntity defHome = resp.get();
        careWorkerEntity.setCareHome(defHome);
        
        BeanUtils.copyProperties(careWorkerRepository.save(careWorkerEntity), toReturn);
        toReturn.setOperationMessage("Care worker added");
        toReturn.setCareHomeId(careWorkerEntity.getCareHome().getCareHomeId());
        return toReturn;
    }
    
    @Override
    public CareWorkerResponse editCareWorker(CareWorkerRequest careWorkerRequest) {
    	if (careWorkerRepository.existsById(careWorkerRequest.getCareWorkerId())) {
    		Optional<CareWorkerEntity> carWrkEnt = careWorkerRepository.findById(careWorkerRequest.getCareWorkerId());
        	CareWorkerEntity careWorkerEntity = carWrkEnt.get();
        	CareWorkerResponse toReturn = new CareWorkerResponse();
            BeanUtils.copyProperties(careWorkerRequest, careWorkerEntity, Utility.getNullPropertyNames(careWorkerRequest));
        	BeanUtils.copyProperties(careWorkerRepository.save(careWorkerEntity), toReturn);
            toReturn.setOperationMessage("edit Complete");
            return toReturn;
    	}
    	else {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());
    	}
    }
    
    @Override
	public Object deleteCareWorker(long careWorkerId) {
    	if (careWorkerRepository.existsById(careWorkerId)) {
    		Optional<CareWorkerEntity> carWrkEnt = careWorkerRepository.findById(careWorkerId);
        	CareWorkerEntity careWorkerEntity = carWrkEnt.get();
        	if (careWorkerEntity.isArchived()) {
        		//?enter a passcode request for extra security?
        		careWorkerRepository.deleteById(careWorkerId);
            	return Collections.singletonMap("operationMessage", "Care worker profile by ID"+careWorkerId+" was deleted");
        	}
        	else {
        		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.DELETE_ERROR.getErrorMessage());
        	}
        	
    	}
    	else {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());
    	}
	}
    
    @Override
    public ArrayList<CareWorkerResponse> getAllCareWorkersForHome(long careHomeId) {
        ArrayList<CareWorkerResponse> toReturn = new ArrayList<>();
    	Optional<CareHomeEntity> resp = careHomeRepository.findById(careHomeId);
        CareHomeEntity careHome = resp.get();
        List<CareWorkerEntity> allCareWorkersForHome = careHome.getCareWorkers();
        
        for (CareWorkerEntity cwEntity: allCareWorkersForHome) {
        	CareWorkerResponse cwResponse = new CareWorkerResponse();
            BeanUtils.copyProperties(cwEntity, cwResponse);
            toReturn.add(cwResponse);
        }
        return toReturn;
    }

	@Override
	public CareWorkerResponse getCareWorker(long careWorkerId) {
		Optional<CareWorkerEntity> resp = careWorkerRepository.findById(careWorkerId);
		if (resp.isEmpty()) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());
		} else {
			CareWorkerEntity cwEntity = resp.get();
			CareWorkerResponse cwResp = new CareWorkerResponse();
            BeanUtils.copyProperties(cwEntity, cwResp);
            return cwResp;
		}
	}
}