package com.example.ecommerce_messaging.model.DTO;

import com.example.ecommerce_messaging.model.enums.NotificationType;
import com.example.ecommerce_messaging.model.enums.ReferenceType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NotificationEventDTO(

        Long userId,
        String title,
        String message,
        Boolean isRead,
        NotificationType type,
        Long referenceId,
        ReferenceType referenceType, // produto | pedido | etc
        Instant timestamp
) {}