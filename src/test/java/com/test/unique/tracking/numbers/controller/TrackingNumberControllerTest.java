package com.test.unique.tracking.numbers.controller;

import com.test.unique.tracking.numbers.model.TrackingResponse;
import com.test.unique.tracking.numbers.service.TrackingNumberService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.ZonedDateTime;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TrackingNumberController.class)
public class TrackingNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrackingNumberService service;

    @Test
    public void testGetTrackingNumber() throws Exception {
        TrackingResponse mockResponse = new TrackingResponse("USINTESTUSER100", ZonedDateTime.now());

        Mockito.when(service.generateTrackingNumber(any(), any(), any(Double.class),
                any(), any(UUID.class), any(), any())).thenReturn(mockResponse);

        mockMvc.perform(get("/next-tracking-number")
                        .param("origin_country_id", "US")
                        .param("destination_country_id", "IN")
                        .param("weight", "2.0")
                        .param("created_at", ZonedDateTime.now().toString())
                        .param("customer_id", UUID.randomUUID().toString())
                        .param("customer_name", "Test User")
                        .param("customer_slug", "testuser"))
                .andExpect(status().isOk());
    }
}
