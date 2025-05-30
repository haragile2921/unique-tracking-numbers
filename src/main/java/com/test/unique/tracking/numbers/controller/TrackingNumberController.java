package com.test.unique.tracking.numbers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.unique.tracking.numbers.model.TrackingRequest;
import com.test.unique.tracking.numbers.model.TrackingResponse;
import com.test.unique.tracking.numbers.service.TrackingNumberService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/next-tracking-number")
public class TrackingNumberController {

    private final TrackingNumberService service;

    public TrackingNumberController(TrackingNumberService service) {
        this.service = service;
    }

@GetMapping
public TrackingResponse getTrackingNumber(@Valid @ModelAttribute TrackingRequest request) {
    return service.generateTrackingNumber(
            request.getOrigin_country_id(),
            request.getDestination_country_id(),
            request.getWeight(),
            request.getCreated_at(),
            request.getCustomer_id(),
            request.getCustomer_name(),
            request.getCustomer_slug()
    );
}

}
