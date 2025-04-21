package com.mysociety.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysociety.model.entity.Floor;

public interface FloorRepository extends JpaRepository<Floor, Long> {

	Optional<Floor> findByFloorNumberAndWingIdAndSocietyId(Integer floorNumber, Long id, Long id2);
}
