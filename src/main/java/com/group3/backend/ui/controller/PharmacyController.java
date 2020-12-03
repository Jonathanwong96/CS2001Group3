package com.group3.backend.ui.controller;

import com.group3.backend.ui.model.request.PharmacyRequest;
import com.group3.backend.ui.model.request.UserDetailsRequestModel;
import com.group3.backend.ui.model.response.PharmacyResponse;
import com.group3.backend.service.PharmacyService;
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
    public PharmacyResponse addPharmacy(@RequestBody PharmacyRequest pharmacyRequest) {
        return pharmacyService.createPharmacy(pharmacyRequest);
    }
    
    @GetMapping
    public ArrayList<PharmacyResponse> getAllPharmaciesForHome(@RequestBody UserDetailsRequestModel udrm) {
        return pharmacyService.getAllPharmaciesForHome(udrm.getCareHomeId());
    }
}
