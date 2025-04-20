package com.mysociety.factory;

import java.time.LocalDateTime;

import com.mysociety.model.entity.Flat;
import com.mysociety.model.entity.OwnerShipStatus;
import com.mysociety.model.entity.Role;
import com.mysociety.model.entity.Society;
import com.mysociety.model.entity.User;

public class UserFactory {

    private UserFactory() {
        // Private constructor to prevent instantiation
    }

    // Method for creating a Resident (Owner or Tenant)
    public static User createResident(String name, String email, String phoneNumber, String password,
                                      Flat flat, Society society, Role role, boolean isOwner) {
        if (flat == null || society == null || role == null) {
            throw new IllegalArgumentException("Flat, Society, and Role must not be null for Resident creation.");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password); // Should be encoded before passing
        user.setFlat(flat);
        user.setSociety(society);
        user.setRole(role);
        user.setOwnershipStatus(isOwner ? OwnerShipStatus.PRIMARY_RESIDENT : OwnerShipStatus.LIMITED_OWNER);
        user.setMaintenancePaid(false);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return user;
    }

    // Method for creating a Security Guard
    public static User createSecurity(String name, String email, String phoneNumber, String password,
                                      Society society, Role role) {
        if (society == null || role == null) {
            throw new IllegalArgumentException("Society and Role must not be null for Security creation.");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password); // Should be encoded before passing
        user.setFlat(null); // Security guards have no flat
        user.setSociety(society);
        user.setRole(role);
        user.setOwnershipStatus(OwnerShipStatus.PRIMARY_RESIDENT); // For security, irrelevant
        user.setMaintenancePaid(false);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return user;
    }

    // Method for creating an Admin
    public static User createAdmin(String name, String email, String phoneNumber, String password,
                                   Society society, Role role) {
        if (society == null || role == null) {
            throw new IllegalArgumentException("Society and Role must not be null for Admin creation.");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password); // Should be encoded before passing
        user.setFlat(null); // Admin is society-wide
        user.setSociety(society);
        user.setRole(role);
        user.setOwnershipStatus(OwnerShipStatus.PRIMARY_RESIDENT); // Admins not tracked separately
        user.setMaintenancePaid(false);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return user;
    }
}
