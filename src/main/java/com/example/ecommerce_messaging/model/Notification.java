package com.example.ecommerce_messaging.model;

import com.example.ecommerce_messaging.model.enums.NotificationType;
import com.example.ecommerce_messaging.model.enums.ReferenceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "notification")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {

    @Id
    private String id;

    private Long userId;
    private String title;
    private String message;
    private Boolean isRead;
    private NotificationType type;

    private Long referenceId; // ex: orderId
    private ReferenceType referenceType;
    private Instant timestamp;
}
