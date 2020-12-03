package com.group3.backend.service.impl;

import com.group3.backend.datasource.entity.PharmacyEntity;
import com.group3.backend.datasource.repos.PharmacyRepository;
import com.group3.backend.service.PharmacyService;
import com.group3.backend.ui.model.request.PharmacyRequest;
import com.group3.backend.ui.model.response.PharmacyResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PharmacyServiceImpl implements PharmacyService {
    @Autowired
    PharmacyRepository pharmacyRepository;

    @Override
    public PharmacyResponse createPharmacy(PharmacyRequest pharmacyRequest) {
    	PharmacyResponse toReturn = new PharmacyResponse();
    	PharmacyEntity pharmacyEntity = new PharmacyEntity();
        BeanUtils.copyProperties(pharmacyRequest, pharmacyEntity);
        PharmacyEntity savedPharmacy = pharmacyRepository.save(pharmacyEntity);
        BeanUtils.copyProperties(savedPharmacy, toReturn);

        return toReturn;
    }

    @Override
    public ArrayList<PharmacyResponse> getAllPharmaciesForHome(long careHomeId) {
        ArrayList<PharmacyResponse> toReturn = new ArrayList<>();
        List<PharmacyEntity> allPharmaciesForHome = pharmacyRepository.findAllByCareHomeId(careHomeId);
        for (PharmacyEntity pEntity: allPharmaciesForHome) {
            PharmacyResponse pResponse = new PharmacyResponse();
            BeanUtils.copyProperties(pEntity, pResponse);
            toReturn.add(pResponse);
        }
        return toReturn;
    }
}
