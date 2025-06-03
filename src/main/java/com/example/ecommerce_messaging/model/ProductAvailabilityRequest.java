package com.example.ecommerce_messaging.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("Product_Availability_Requests")
@Data
@Builder
public class ProductAvailabilityRequest {

    @Id
    private String id;

    private Long userId;
    private Long productId;
    private Instant timestamp;
}
