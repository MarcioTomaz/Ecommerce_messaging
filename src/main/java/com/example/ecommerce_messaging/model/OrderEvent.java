package com.example.ecommerce_messaging.model;

import com.example.ecommerce_messaging.model.enums.AlteredByType;
import com.example.ecommerce_messaging.model.enums.ExecutionType;
import com.example.ecommerce_messaging.model.enums.OrderStatus;

import java.time.Instant;

public record OrderEvent(
        Long orderId,
        OrderStatus status,
        String refuseReason,
        AlteredByType alteredByType,   // USER ou SYSTEM
        ExecutionType executionType,   // MANUAL ou AUTOMATIC
        UserPersonLOG userLog,         // Preenchido se alteredByType == USER
        Instant timestamp
) {}
