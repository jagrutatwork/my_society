package com.mysociety.repository;

import com.mysociety.model.entity.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlatRepository extends JpaRepository<Flat, Long> {
    List<Flat> findBySocietyId(Long societyId);
    List<Flat> findByWingId(Long wingId);
}
