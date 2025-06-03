package com.example.ecommerce_messaging.producer;


import com.example.ecommerce_messaging.model.Notification;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    private static final String TOPIC = "notification.topic";

    public void sendNotification(Notification event) {

        try {

            String json = objectMapper.writeValueAsString(event);
            kafkaTemplate.send(TOPIC, event.getUserId().toString(), json);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
