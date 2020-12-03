package com.group3.backend.ui.controller;

import com.group3.backend.service.PharmacyService;
import com.group3.backend.ui.model.request.PharmacyRequest;
import com.group3.backend.ui.model.request.UserRequest;
import com.group3.backend.ui.model.response.PharmacyResponse;
import com.group3.backend.ui.security.AuthorisationFilter;
import com.group3.backend.ui.security.JwtData;
import com.group3.backend.ui.security.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController //So we can use GET, POST, PUT methods
@RequestMapping("pharmacy") //to define the URL. oursite.com/
public class PharmacyController {

    @Autowired
    PharmacyService pharmacyService;

    @PostMapping
    public PharmacyResponse addPharmacy(@RequestBody PharmacyRequest pRequest,
                                        @RequestHeader(SecurityConstants.HEADER_STRING) String jwt) {
        JwtData data = AuthorisationFilter.decodeJwt(jwt);
        return pharmacyService.createPharmacy(pRequest, Long.parseLong(data.getCareHomeId()));
    }
    
    @GetMapping
    public ArrayList<PharmacyResponse> getAllPharmaciesForHome(@RequestHeader(SecurityConstants.HEADER_STRING) String jwt) {
        JwtData data = AuthorisationFilter.decodeJwt(jwt);
        return pharmacyService.getAllPharmaciesForHome(Long.parseLong(data.getCareHomeId()));
    }
}
