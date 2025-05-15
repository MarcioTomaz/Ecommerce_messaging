package com.example.ecommerce_messaging.model;

import com.example.ecommerce_messaging.model.enums.OrderStatus;

import java.time.Instant;

public record OrderEvent(
        Long orderId,
        OrderStatus status,
        UserPersonLOG userLog,
        Instant timestamp
) {
}