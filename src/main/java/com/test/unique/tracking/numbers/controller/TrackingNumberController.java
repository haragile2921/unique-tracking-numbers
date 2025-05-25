package com.test.unique.tracking.numbers.controller;

import com.test.unique.tracking.numbers.model.TrackingResponse;
import com.test.unique.tracking.numbers.service.TrackingNumberService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/next-tracking-number")
public class TrackingNumberController {

    private final TrackingNumberService service;

    public TrackingNumberController(TrackingNumberService service) {
        this.service = service;
    }

    @GetMapping
    public TrackingResponse getTrackingNumber(
            @RequestParam String origin_country_id,
            @RequestParam String destination_country_id,
            @RequestParam double weight,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime created_at,
            @RequestParam UUID customer_id,
            @RequestParam String customer_name,
            @RequestParam String customer_slug) {

        return service.generateTrackingNumber(origin_country_id, destination_country_id, weight,
                created_at, customer_id, customer_name, customer_slug);
    }
}
