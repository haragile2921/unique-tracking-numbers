package com.test.unique.tracking.numbers.model;
import java.time.ZonedDateTime;

public class TrackingResponse {
    private String tracking_number;
    private ZonedDateTime created_at;

    public TrackingResponse(String tracking_number, ZonedDateTime created_at) {
        this.tracking_number = tracking_number;
        this.created_at = created_at;
    }

    public String getTracking_number() {
        return tracking_number;
    }

    public ZonedDateTime getCreated_at() {
        return created_at;
    }
}