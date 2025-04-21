package com.mysociety.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysociety.model.entity.Flat;

public interface FlatRepository extends JpaRepository<Flat, Long> {
    List<Flat> findBySocietyId(Long societyId);
    List<Flat> findByWingId(Long wingId);
	Optional<Flat> findByFloorIdAndWingIdAndSocietyIdAndFlatNumber(Long id, Long id2, Long id3, String flatNumber);
}
