package com.test.unique.tracking.numbers.model;
 
import jakarta.validation.constraints.*; import org.springframework.format.annotation.DateTimeFormat;
 
import java.time.ZonedDateTime; import java.util.UUID;
 
public class TrackingRequest {
 
@NotBlank
@Pattern(regexp = "^[A-Z]{2}$")
private String origin_country_id;
 
@NotBlank
@Pattern(regexp = "^[A-Z]{2}$")
private String destination_country_id;
 
@DecimalMin("0.001")
@DecimalMax("999.999")
private double weight;
 
@NotNull
@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
private ZonedDateTime created_at;
 
@NotNull
private UUID customer_id;
 
@NotBlank
private String customer_name;
 
@NotBlank
@Pattern(regexp = "^[a-z0-9\\-]+$")
private String customer_slug;
 
// Getters and setters
 
public String getOrigin_country_id() { return origin_country_id; }
public void setOrigin_country_id(String origin_country_id) { this.origin_country_id = origin_country_id; }
 
public String getDestination_country_id() { return destination_country_id; }
public void setDestination_country_id(String destination_country_id) { this.destination_country_id = destination_country_id; }
 
public double getWeight() { return weight; }
public void setWeight(double weight) { this.weight = weight; }
 
public ZonedDateTime getCreated_at() { return created_at; }
public void setCreated_at(ZonedDateTime created_at) { this.created_at = created_at; }
 
public UUID getCustomer_id() { return customer_id; }
public void setCustomer_id(UUID customer_id) { this.customer_id = customer_id; }
 
public String getCustomer_name() { return customer_name; }
public void setCustomer_name(String customer_name) { this.customer_name = customer_name; }
 
public String getCustomer_slug() { return customer_slug; }
public void setCustomer_slug(String customer_slug) { this.customer_slug = customer_slug; }
 
}