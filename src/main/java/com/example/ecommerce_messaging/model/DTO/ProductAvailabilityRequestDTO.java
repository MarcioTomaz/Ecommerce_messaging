package com.example.ecommerce_messaging.model.DTO;

import java.time.Instant;

public record ProductAvailabilityRequestDTO(
        Long userId,
        Long productId,
        Instant timestamp
) {
}
