package com.mysociety.service.interfaces;

import com.mysociety.model.dto.AdminSignupRequest;
import com.mysociety.model.dto.ResidentSignupRequest;
import com.mysociety.model.dto.SecuritySignupRequest;
import com.mysociety.model.entity.User;

public interface SignupService {

    User signupResident(ResidentSignupRequest request);

    User signupSecurity(SecuritySignupRequest request);

    User signupAdmin(AdminSignupRequest request);
}