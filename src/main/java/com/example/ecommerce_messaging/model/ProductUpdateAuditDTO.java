package com.example.ecommerce_messaging.model;

import java.time.Instant;
import java.util.List;

public record ProductUpdateAuditDTO(
        Long productId,
        UserAuditDTO updatedBy,
        Instant updatedAt,
        List<FieldChange> changes) {
}
