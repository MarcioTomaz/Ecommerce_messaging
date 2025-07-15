package com.example.ecommerce_messaging.model;

public record FieldChange(
        String field,
        String oldValue,
        String newValue
) {}