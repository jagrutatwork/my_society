package com.mysociety.service.impl;

import org.springframework.security.access.AccessDeniedException; // ✅ CORRECT
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.mysociety.model.dto.request.DeliveryApprovalRequest;
import com.mysociety.model.dto.response.DeliveryApprovalResponse;
import com.mysociety.model.entity.Delivery;
import com.mysociety.model.entity.Flat;
import com.mysociety.model.entity.User;
import com.mysociety.repository.DeliveryRepository;
import com.mysociety.repository.FlatRepository;
import com.mysociety.repository.UserRepository;
import com.mysociety.service.interfaces.DeliveryService;


@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private FlatRepository flatRepository;

    @Autowired
    private UserRepository userRepository;

    
    @Override
    public Delivery createDeliveryRequest(DeliveryApprovalRequest request){
        Flat flat = flatRepository.findById(request.getFlatId())
                .orElseThrow(() -> new IllegalArgumentException("Flat not found"));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) authentication.getPrincipal();

        User guard = userRepository.findByEmail(username)
                .orElseThrow(() -> new IllegalArgumentException("Security Guard not found"));
        
        if (!guard.getRole().getName().equals("ROLE_SECURITY_GUARD")) {
            throw new AccessDeniedException("User with role " + guard.getRole().getName() + " is not allowed to raise delivery approval request");
        }


        Delivery delivery = new Delivery();
        delivery.setFlat(flat);
        delivery.setRequestedBy(guard);
        delivery.setRequestedAt(LocalDateTime.now());
        delivery.setNote(request.getNote());
        delivery.setApproved(null); // pending

        return deliveryRepository.save(delivery);
    }


    @Override
    public Delivery respondToDelivery(DeliveryApprovalResponse response) {
        Delivery delivery = deliveryRepository.findById(response.getRequestId())
                .orElseThrow(() -> new IllegalArgumentException("Delivery request not found"));

        if (delivery.getApproved() != null) {
            throw new IllegalStateException("Delivery already responded to");
        }

        User resident = userRepository.findById(response.getRespondedById())// --> ISSUE DOESMT EXIST
                .orElseThrow(() -> new IllegalArgumentException("Resident not found"));
        
        if (!resident.getRole().getName().equals("ROLE_SECURITY_GUARD")) {
            throw new AccessDeniedException("User with role " + resident.getRole().getName() + " is not allowed to raise delivery approval request");
        }

        delivery.setApproved(response.isApproved());
        delivery.setRespondedAt(LocalDateTime.now());
        delivery.setRespondedBy(resident);

        return deliveryRepository.save(delivery);
    }

    @Override
    public List<Delivery> getDeliveriesForFlat(Long flatId) {
        return deliveryRepository.findByFlatId(flatId);
    }

    @Override
    public List<Delivery> getPendingDeliveriesForFlat(Long flatId) {
        return deliveryRepository.findByFlatIdAndApprovedIsNull(flatId);
    }
}
