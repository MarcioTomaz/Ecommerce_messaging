package com.example.ecommerce_messaging.consumer;


import com.example.ecommerce_messaging.mapper.OrderEventMapper;
import com.example.ecommerce_messaging.model.OrderEvent;
import com.example.ecommerce_messaging.model.OrderLog;
import com.example.ecommerce_messaging.repository.OrderLogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderKafkaConsumer {

    @Autowired
    private OrderLogRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "order.status", groupId = "order-logs")
    public void listen(String message) {
        try {

            OrderEvent event = objectMapper.readValue(message, OrderEvent.class);

            OrderLog log = OrderEventMapper.toOrderLog(event);

            repository.save(log);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
