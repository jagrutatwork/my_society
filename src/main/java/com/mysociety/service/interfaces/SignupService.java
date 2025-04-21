package com.mysociety.service.interfaces;

import com.mysociety.model.dto.request.AdminSignupRequest;
import com.mysociety.model.dto.request.ResidentSignupRequest;
import com.mysociety.model.dto.request.SecuritySignupRequest;
import com.mysociety.model.entity.User;

public interface SignupService {

    User signupResident(ResidentSignupRequest request);

    User signupSecurity(SecuritySignupRequest request);

    User signupAdmin(AdminSignupRequest request);
}