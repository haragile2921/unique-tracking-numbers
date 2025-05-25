Scalable Tracking Number Generator API
 
A Spring Boot-based REST API that generates unique tracking numbers for parcel orders, designed to handle high concurrency and ensure scalability.
 
Features
 
RESTful endpoint for tracking number generation
 
Ensures uniqueness of tracking numbers
 
Supports high concurrency using concurrent data structures
 
Input validation for all parameters
 
RFC 3339-compliant timestamps
 
Lightweight H2 in-memory database for testing
 
 
Technologies Used
 
Java 17+
 
Spring Boot 3.x
 
Spring Web
 
Spring Validation
 
H2 Database (in-memory)
 
 
Endpoint
 
GET /next-tracking-number
 
Query Parameters
 
Parameter Type Description
 
origin_country_id String ISO 3166-1 alpha-2 format (e.g., "MY")
destination_country_id String ISO 3166-1 alpha-2 format (e.g., "ID")
weight Decimal Order weight in kg (up to 3 decimal places)
created_at DateTime RFC 3339 format timestamp
customer_id UUID Customer UUID
customer_name String Customer name (e.g., "RedBox Logistics")
customer_slug String Slug/kebab-case version of customer name
 
 
Response Result
 
{
  "tracking_number": "MYID3E7912",
  "created_at": "2025-08-13T14
}