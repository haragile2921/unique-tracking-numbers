package com.test.unique.tracking.numbers.repository;

import com.test.unique.tracking.numbers.model.TrackingCounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingCounterRepository extends JpaRepository<TrackingCounter, Long> {
}