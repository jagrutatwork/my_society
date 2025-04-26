package com.mysociety.service.interfaces;

import java.nio.file.AccessDeniedException;
import java.util.List;

import com.mysociety.model.dto.request.DeliveryApprovalRequest;
import com.mysociety.model.dto.response.DeliveryApprovalResponse;
import com.mysociety.model.entity.Delivery; 

public interface DeliveryService {

    // Called by security guard to initiate delivery approval8
    Delivery createDeliveryRequest(DeliveryApprovalRequest request);

    // Called by resident to approve or reject
    Delivery respondToDelivery(DeliveryApprovalResponse response);

    // Get all deliveries for a flat (history view)
    List<Delivery> getDeliveriesForFlat(Long flatId);

    // Get pending approvals for a flat
    List<Delivery> getPendingDeliveriesForFlat(Long flatId);
}
