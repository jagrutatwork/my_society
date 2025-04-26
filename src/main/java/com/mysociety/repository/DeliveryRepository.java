package com.mysociety.repository;

import com.mysociety.model.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    // Get all deliveries for a flat
    List<Delivery> findByFlatId(Long flatId);

    // Get all pending deliveries for a flat
    List<Delivery> findByFlatIdAndApprovedIsNull(Long flatId);

    // Optional: Get all deliveries requested by a specific guard
    List<Delivery> findByRequestedById(Long userId);
}
