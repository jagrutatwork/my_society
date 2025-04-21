package com.mysociety.repository;

import com.mysociety.model.entity.Wing;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WingRepository extends JpaRepository<Wing, Long> {

	Optional<Wing> findByNameAndSocietyId(String wingName, Long societyId);
}
