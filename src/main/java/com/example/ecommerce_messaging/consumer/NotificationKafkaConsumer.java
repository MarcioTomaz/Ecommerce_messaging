package com.example.ecommerce_messaging.consumer;

import com.example.ecommerce_messaging.model.DTO.NotificationEventDTO;
import com.example.ecommerce_messaging.model.Notification;
import com.example.ecommerce_messaging.repository.NotificationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class NotificationKafkaConsumer {

    private final NotificationRepository notificationRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "notification.topic", groupId = "notification-group")
    public void listen(String message) {

        try {

            Notification notification = objectMapper.readValue(message, Notification.class);
            notificationRepository.save(notification);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
