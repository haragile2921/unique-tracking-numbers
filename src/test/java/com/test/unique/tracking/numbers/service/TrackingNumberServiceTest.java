package com.test.unique.tracking.numbers.service;

import com.test.unique.tracking.numbers.model.TrackingCounter;
import com.test.unique.tracking.numbers.model.TrackingResponse;
import com.test.unique.tracking.numbers.repository.TrackingCounterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.ZonedDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TrackingNumberServiceTest {

    private TrackingCounterRepository repository;
    private TrackingNumberService service;

    @BeforeEach
    public void setup() {
        repository = mock(TrackingCounterRepository.class);
        service = new TrackingNumberService(repository);
    }

    @Test
    public void testGenerateTrackingNumber() {
        TrackingCounter savedCounter = new TrackingCounter();
        savedCounter.setId(100L);
        when(repository.save(any(TrackingCounter.class))).thenReturn(savedCounter);

        String origin = "US";
        String destination = "IN";
        double weight = 5.5;
        ZonedDateTime createdAt = ZonedDateTime.now();
        UUID customerId = UUID.randomUUID();
        String customerName = "Test User";
        String customerSlug = "testuser";

        TrackingResponse response = service.generateTrackingNumber(origin, destination, weight,
                createdAt, customerId, customerName, customerSlug);

        assertNotNull(response);
        assertNotNull(response.getTracking_number());
        assertTrue(response.getTracking_number().length() <= 16);
        verify(repository, times(1)).save(any(TrackingCounter.class));
    }
}
