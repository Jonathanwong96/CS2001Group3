package com.group3.backend.service;

import com.group3.backend.ui.model.request.PharmacyRequest;
import com.group3.backend.ui.model.request.UserRequest;
import com.group3.backend.ui.model.response.PharmacyResponse;

import java.util.ArrayList;

public interface PharmacyService {
    PharmacyResponse createPharmacy(PharmacyRequest pRequest, long careHomeId);
    ArrayList<PharmacyResponse> getAllPharmaciesForHome(long careHomeId);
}
