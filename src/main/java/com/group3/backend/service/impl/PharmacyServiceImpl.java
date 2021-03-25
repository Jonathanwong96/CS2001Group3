package com.group3.backend.service.impl;

import com.group3.backend.datasource.entity.CareHomeEntity;
import com.group3.backend.datasource.entity.PharmacyEntity;
import com.group3.backend.datasource.repos.CareHomeRepository;
import com.group3.backend.datasource.repos.PharmacyRepository;
import com.group3.backend.service.PharmacyService;
import com.group3.backend.ui.model.request.PharmacyRequest;
import com.group3.backend.ui.model.response.ErrorMessages;
import com.group3.backend.ui.model.response.PharmacyResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PharmacyServiceImpl implements PharmacyService {
    @Autowired
    PharmacyRepository pharmacyRepository;
    
    @Autowired CareHomeRepository careHomeRepository;

    @Override
    public PharmacyResponse createPharmacy(PharmacyRequest pharmacyRequest) {
        Optional<CareHomeEntity> resp = careHomeRepository.findById(pharmacyRequest.getCareHomeId());
        if (resp.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());
        } else {
            PharmacyResponse toReturn = new PharmacyResponse();
            PharmacyEntity pharmacyEntity = new PharmacyEntity();
            BeanUtils.copyProperties(pharmacyRequest, pharmacyEntity);
            pharmacyEntity.setCareHome(resp.get());
            PharmacyEntity savedPharmacy = pharmacyRepository.save(pharmacyEntity);
            BeanUtils.copyProperties(savedPharmacy, toReturn);
            return toReturn;
        }
    }

    @Override
    public ArrayList<PharmacyResponse> getAllPharmaciesForHome(long careHomeId) {
        ArrayList<PharmacyResponse> toReturn = new ArrayList<>();
    	Optional<CareHomeEntity> resp = careHomeRepository.findById(careHomeId);
    	if (resp.isEmpty()) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());
    	} else {
    		CareHomeEntity careHome = resp.get();
    		List<PharmacyEntity> allPharmaciesForHome = careHome.getPharmacies();
    		for (PharmacyEntity pEntity: allPharmaciesForHome) {
                PharmacyResponse pResponse = new PharmacyResponse();
                BeanUtils.copyProperties(pEntity, pResponse);
                pResponse.setPharmacyId(pEntity.getId());
                toReturn.add(pResponse);
            }
            return toReturn;
    	}
    }
}
