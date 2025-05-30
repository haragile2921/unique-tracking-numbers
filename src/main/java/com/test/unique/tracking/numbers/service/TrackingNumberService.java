package com.test.unique.tracking.numbers.service;


import com.test.unique.tracking.numbers.model.TrackingCounter;
import com.test.unique.tracking.numbers.model.TrackingResponse;
import com.test.unique.tracking.numbers.repository.TrackingCounterRepository;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
public class TrackingNumberService {

    private final TrackingCounterRepository repository;

    public TrackingNumberService(TrackingCounterRepository repository) {
        this.repository = repository;
    }

    public TrackingResponse generateTrackingNumber(String origin, String destination, double weight,
                                                   ZonedDateTime createdAt, UUID customerId,
                                                   String customerName, String customerSlug) {
                                                    if (origin == null || destination == null) {
                                                        throw new IllegalArgumentException("Origin and destination must not be null");
                                                    }
                                                
                                                    try {
                                                        TrackingCounter counter = repository.save(new TrackingCounter());
                                                        Long id = counter.getId();
                                                        String base = (origin + destination + customerSlug + id).toUpperCase().replaceAll("[^A-Z0-9]", "");
                                                        String trackingNumber = base.substring(0, Math.min(16, base.length()));
                                                        return new TrackingResponse(trackingNumber, ZonedDateTime.now());
                                                    } catch (Exception e) {
                                                        throw new RuntimeException("Error generating tracking number", e);
                                                    }
    }
}