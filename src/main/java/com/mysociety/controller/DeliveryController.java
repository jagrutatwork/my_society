package com.mysociety.controller;

import com.mysociety.model.dto.request.DeliveryApprovalRequest;
import com.mysociety.model.dto.response.DeliveryApprovalResponse;
import com.mysociety.model.entity.Delivery;
import com.mysociety.service.interfaces.DeliveryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    // 1️⃣ Create a delivery request (Security Guard)
    @PostMapping("/request")
    public Delivery createDeliveryRequest(@RequestBody DeliveryApprovalRequest request) {
        return deliveryService.createDeliveryRequest(request);
    }

    // 2️⃣ Respond to a delivery request (Resident)
    @PostMapping("/respond")
    public Delivery respondToDelivery(@RequestBody DeliveryApprovalResponse response) {
        return deliveryService.respondToDelivery(response);
    }

    // 3️⃣ Get all deliveries for a flat
    @GetMapping("/flat/{flatId}")
    public List<Delivery> getAllDeliveriesForFlat(@PathVariable Long flatId) {
        return deliveryService.getDeliveriesForFlat(flatId);
    }

    // 4️⃣ Get only pending deliveries for a flat
    @GetMapping("/flat/{flatId}/pending")
    public List<Delivery> getPendingDeliveriesForFlat(@PathVariable Long flatId) {
        return deliveryService.getPendingDeliveriesForFlat(flatId);
    }
}
