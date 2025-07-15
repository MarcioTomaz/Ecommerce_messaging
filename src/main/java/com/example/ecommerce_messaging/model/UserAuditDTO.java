package com.example.ecommerce_messaging.model;

public record UserAuditDTO(
        Long id,
        String name,
        String email,
        String role
) {
}