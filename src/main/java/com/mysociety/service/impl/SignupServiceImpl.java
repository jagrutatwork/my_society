package com.mysociety.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mysociety.factory.UserFactory;
import com.mysociety.model.dto.request.AdminSignupRequest;
import com.mysociety.model.dto.request.ResidentSignupRequest;
import com.mysociety.model.dto.request.SecuritySignupRequest;
import com.mysociety.model.entity.Flat;
import com.mysociety.model.entity.Floor;
import com.mysociety.model.entity.Role;
import com.mysociety.model.entity.Society;
import com.mysociety.model.entity.User;
import com.mysociety.model.entity.Wing;
import com.mysociety.repository.FlatRepository;
import com.mysociety.repository.FloorRepository;
import com.mysociety.repository.RoleRepository;
import com.mysociety.repository.SocietyRepository;
import com.mysociety.repository.UserRepository;
import com.mysociety.repository.WingRepository;
import com.mysociety.service.interfaces.SignupService;

@Service
public class SignupServiceImpl implements SignupService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SocietyRepository societyRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private WingRepository wingRepository;

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private FlatRepository flatRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User signupResident(ResidentSignupRequest request) {
        // 1. Validate Society
        Society society = societyRepository.findById(request.getSocietyId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid society ID"));

        // 2. Find Wing by Wing Name + Society ID
        Wing wing = wingRepository.findByNameAndSocietyId(request.getWingName(), request.getSocietyId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Wing Name for this Society"));

        // 3. Find Floor by Floor Number + Wing ID + Society ID
        Floor floor = floorRepository.findByFloorNumberAndWingIdAndSocietyId(
                request.getFloorNumber(), wing.getId(), society.getId()
        ).orElseThrow(() -> new IllegalArgumentException("Invalid Floor Number for Wing in Society"));

        // 4. Find Flat by Flat Number + Floor ID + Wing ID + Society ID
        Flat flat = flatRepository.findByFloorIdAndWingIdAndSocietyIdAndFlatNumber(
                floor.getId(),
                wing.getId(),
                society.getId(),
                request.getFlatNumber()
        ).orElseThrow(() -> new IllegalArgumentException("Flat not found with given details"));

        // 5. Fetch the Role: RESIDENT
        Role residentRole = roleRepository.findByName("RESIDENT")
                .orElseThrow(() -> new IllegalArgumentException("Resident role not found"));

        // 6. Encode the password
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // 7. Use UserFactory to create the User object
        User user = UserFactory.createResident(
                request.getName(),
                request.getEmail(),
                request.getPhoneNumber(),
                encodedPassword,
                flat,
                society,
                residentRole,
                request.getIsOwner()
        );

        // 8. Save and return the User
        return userRepository.save(user);
    }

    @Override
    public User signupSecurity(SecuritySignupRequest request) {
        Society society = societyRepository.findById(request.getSocietyId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid society ID"));

        Role securityRole = roleRepository.findByName("SECURITY_GUARD")
                .orElseThrow(() -> new IllegalArgumentException("Security Guard role not found"));

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = UserFactory.createSecurity(
                request.getName(),
                request.getEmail(),
                request.getPhoneNumber(),
                encodedPassword,
                society,
                securityRole
        );

        return userRepository.save(user);
    }

    @Override
    public User signupAdmin(AdminSignupRequest request) {
        Society society = societyRepository.findById(request.getSocietyId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid society ID"));

        Role adminRole = roleRepository.findByName("ADMIN")
                .orElseThrow(() -> new IllegalArgumentException("Admin role not found"));

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = UserFactory.createAdmin(
                request.getName(),
                request.getEmail(),
                request.getPhoneNumber(),
                encodedPassword,
                society,
                adminRole
        );

        return userRepository.save(user);
    }


}
