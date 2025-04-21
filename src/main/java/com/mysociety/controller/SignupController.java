package com.mysociety.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysociety.model.dto.request.AdminSignupRequest;
import com.mysociety.model.dto.request.ResidentSignupRequest;
import com.mysociety.model.dto.request.SecuritySignupRequest;
import com.mysociety.model.entity.User;
import com.mysociety.service.interfaces.SignupService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/signup")
public class SignupController {

    @Autowired
    private SignupService signupService;

    @PostMapping("/resident")
    public ResponseEntity<User> signupResident(@Valid @RequestBody ResidentSignupRequest request) {
        User user = signupService.signupResident(request);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/security")
    public ResponseEntity<User> signupSecurity(@Valid @RequestBody SecuritySignupRequest request) {
        User user = signupService.signupSecurity(request);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/admin")
    public ResponseEntity<User> signupAdmin(@Valid @RequestBody AdminSignupRequest request) {
        User user = signupService.signupAdmin(request);
        return ResponseEntity.ok(user);
    }
    
    
}
