package com.group3.backend.service.impl;


import com.group3.backend.datasource.entity.ResidentEntity;

import com.group3.backend.datasource.repos.ResidentRepository;

import com.group3.backend.service.ResidentService;

import com.group3.backend.ui.model.request.ResidentRequest;

import com.group3.backend.ui.model.response.ResidentResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ResidentServiceImpl implements ResidentService {
    @Autowired
    ResidentRepository residentRepository;

    @Override
    public ResidentResponse createResident(ResidentRequest residentRequest) {
    	ResidentResponse toReturn = new ResidentResponse();
        BeanUtils.copyProperties(repoSave(residentRequest), toReturn);
        return toReturn;
    }
    
    @Override
    public ResidentResponse editResident(ResidentRequest residentRequest) {
    	if (residentRepository.existsById(residentRequest.getResidentId())) {
        	ResidentResponse toReturn = new ResidentResponse();
            BeanUtils.copyProperties(repoSave(residentRequest), toReturn);
            toReturn.setOperationMessage("edit Complete");
            return toReturn;
    	}
    	else {
    		//return user-friendly JSON "Resident by Id not found"
    		return null;
    	}
    }
    
    /**
     * Saves to resident repository and returns the saved residentEntity
     * (?move to utility class?) - SK
     * @param residentRequest
     * @return the saved entity
     */
    private ResidentEntity repoSave(ResidentRequest residentRequest) {
    	ResidentEntity residentEntity = new ResidentEntity();
        BeanUtils.copyProperties(residentRequest, residentEntity);
        return residentRepository.save(residentEntity);	
    }
}