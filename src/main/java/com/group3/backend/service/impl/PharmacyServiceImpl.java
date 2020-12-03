package com.group3.backend.service.impl;

import com.group3.backend.datasource.entity.PharmacyEntity;
import com.group3.backend.datasource.repos.PharmacyRepository;
import com.group3.backend.service.PharmacyService;
import com.group3.backend.shared.PharmacyDto;
import com.group3.backend.shared.UserDto;
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
    public PharmacyDto createPharmacy(PharmacyDto pharmacyDto) {
        PharmacyEntity pharmacyEntity = new PharmacyEntity();
        BeanUtils.copyProperties(pharmacyDto, pharmacyEntity);

        PharmacyDto toReturn = new PharmacyDto();
        PharmacyEntity savedPharmacy = pharmacyRepository.save(pharmacyEntity);
        BeanUtils.copyProperties(savedPharmacy, toReturn);

        return toReturn;
    }

    @Override
    public ArrayList<PharmacyDto> getAllPharmaciesForHome(UserDto userDto) {
        ArrayList<PharmacyDto> toReturn = new ArrayList<>();

        List<PharmacyEntity> allPharmaciesForHome = pharmacyRepository.findAllByCareHomeId(userDto.getCareHomeId());
        for (PharmacyEntity pharmEnt: allPharmaciesForHome) {
            PharmacyDto pDto = new PharmacyDto();
            BeanUtils.copyProperties(pharmEnt, pDto);
            toReturn.add(pDto);
        }
        return toReturn;
    }
}
