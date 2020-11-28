package com.group3.backend.service;

import com.group3.backend.shared.PharmacyDto;
import com.group3.backend.shared.UserDto;

import java.util.ArrayList;

public interface PharmacyService {
    PharmacyDto createPharmacy(PharmacyDto pharmacy);
    ArrayList<PharmacyDto> getAllPharmaciesForHome(UserDto userDto);
}
