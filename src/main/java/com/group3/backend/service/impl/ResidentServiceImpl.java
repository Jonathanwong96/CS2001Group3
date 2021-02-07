package com.group3.backend.service.impl;
import com.group3.backend.datasource.entity.ResidentEntity;

import com.group3.backend.datasource.repos.ResidentRepository;

import com.group3.backend.service.ResidentService;

import com.group3.backend.ui.model.request.ResidentRequest;
import com.group3.backend.ui.model.response.ResidentResponse;

import java.util.ArrayList;
import java.util.List;

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
        toReturn.setOperationMessage("resident added");
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
    		ResidentResponse toReturn = new ResidentResponse();
            toReturn.setOperationMessage("Resident by Id not found");
    		return toReturn;
    	}
    }
    
    @Override
    public ArrayList<ResidentResponse> getAllResidentsForHome(long careHomeId) {
        ArrayList<ResidentResponse> toReturn = new ArrayList<>();
        List<ResidentEntity> allResidentsForHome = residentRepository.findAllByCareHomeId(careHomeId);
        for (ResidentEntity rEntity: allResidentsForHome) {
        	ResidentResponse rResponse = new ResidentResponse();
            BeanUtils.copyProperties(rEntity, rResponse);
            toReturn.add(rResponse);
        }
        return toReturn;
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