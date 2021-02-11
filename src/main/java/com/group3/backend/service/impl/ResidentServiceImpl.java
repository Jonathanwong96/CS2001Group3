package com.group3.backend.service.impl;
import com.group3.backend.datasource.entity.ResidentEntity;
import com.group3.backend.datasource.entity.CareHomeEntity;

import com.group3.backend.datasource.repos.ResidentRepository;
import com.group3.backend.datasource.repos.CareHomeRepository;

import com.group3.backend.service.ResidentService;
import com.group3.backend.service.helper.Utility;
import com.group3.backend.ui.model.request.ResidentRequest;
import com.group3.backend.ui.model.response.ErrorMessages;
import com.group3.backend.ui.model.response.ResidentResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ResidentServiceImpl implements ResidentService {
    @Autowired
    ResidentRepository residentRepository;
    
    @Autowired 
    CareHomeRepository careHomeRepository;


    @Override
    public ResidentResponse createResident(ResidentRequest residentRequest) {
    	ResidentResponse toReturn = new ResidentResponse();
    	ResidentEntity residentEntity = new ResidentEntity();
        BeanUtils.copyProperties(residentRequest, residentEntity);
        BeanUtils.copyProperties(residentRepository.save(residentEntity), toReturn);
        toReturn.setOperationMessage("resident added");
        return toReturn;
    }
    
    @Override
    public ResidentResponse editResident(ResidentRequest residentRequest) {
    	if (residentRepository.existsById(residentRequest.getResidentId())) {
    		Optional<ResidentEntity> resEnt = residentRepository.findById(residentRequest.getResidentId());
        	ResidentEntity residentEntity = resEnt.get();
        	ResidentResponse toReturn = new ResidentResponse();
            BeanUtils.copyProperties(residentRequest, residentEntity, Utility.getNullPropertyNames(residentRequest));
        	BeanUtils.copyProperties(residentRepository.save(residentEntity), toReturn);
            toReturn.setOperationMessage("edit Complete");
            return toReturn;
    	}
    	else {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorMessages.RESIDENT_NOT_FOUND.getErrorMessage());

    	}
    }
    
    @Override
    public ArrayList<ResidentResponse> getAllResidentsForHome(long careHomeId) {
        ArrayList<ResidentResponse> toReturn = new ArrayList<>();
    	Optional<CareHomeEntity> resp = careHomeRepository.findById(careHomeId);
        CareHomeEntity careHome = resp.get();
        List<ResidentEntity> allResidentsForHome = careHome.getResidents();
        
        for (ResidentEntity rEntity: allResidentsForHome) {
        	ResidentResponse rResponse = new ResidentResponse();
            BeanUtils.copyProperties(rEntity, rResponse);
            toReturn.add(rResponse);
        }
        return toReturn;
    }
}