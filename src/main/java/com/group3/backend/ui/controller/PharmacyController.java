package com.group3.backend.ui.controller;

import com.group3.backend.datasource.entity.PharmacyEntity;
import com.group3.backend.shared.UserDto;
import com.group3.backend.ui.model.request.PharmacyDetailsRequestModel;
import com.group3.backend.ui.model.request.UserDetailsRequestModel;
import com.group3.backend.ui.model.response.PharmacyRest;
import com.group3.backend.service.PharmacyService;
import com.group3.backend.shared.PharmacyDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController //So we can use GET, POST, PUT methods
@RequestMapping("pharmacy") //to define the URL. oursite.com/pharmacy
public class PharmacyController {

    @Autowired
    PharmacyService pharmacyService;

    @PostMapping
    public PharmacyRest addPharmacy(@RequestBody PharmacyDetailsRequestModel pdrm) {
        PharmacyRest toReturn = new PharmacyRest();

        PharmacyDto pharmacyDto = new PharmacyDto();
        BeanUtils.copyProperties(pdrm, pharmacyDto);

        PharmacyDto createdPharmacy = pharmacyService.createPharmacy(pharmacyDto);
        BeanUtils.copyProperties(createdPharmacy, toReturn);

        return toReturn;
    }
    
    @GetMapping
    public ArrayList<PharmacyRest> getAllPharmaciesForHome(@RequestBody UserDetailsRequestModel udrm) {
        ArrayList<PharmacyRest> toReturn = new ArrayList<>();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(udrm, userDto);

        ArrayList<PharmacyDto> allPharmaciesForHome = pharmacyService.getAllPharmaciesForHome(userDto);

        for (PharmacyDto pDto: allPharmaciesForHome) {
            PharmacyRest pRest = new PharmacyRest();
            BeanUtils.copyProperties(pDto, pRest);
            toReturn.add(pRest);
        }
        return toReturn;
    }
}
