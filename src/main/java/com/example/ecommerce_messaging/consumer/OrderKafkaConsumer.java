package com.example.ecommerce_messaging.consumer;


import com.example.ecommerce_messaging.model.OrderEvent;
import com.example.ecommerce_messaging.model.OrderLog;
import com.example.ecommerce_messaging.repository.OrderLogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
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

            OrderLog log = new OrderLog();
            log.setOrderId(event.orderId());
            log.setStatus(event.status().name());
            // Só seta o refuseReason se vier preenchido
            if (event.refuseReason() != null && !event.refuseReason().isBlank()) {
                log.setRefuseReason(event.refuseReason());
            }            log.setUserLog(event.userLog());
            log.setTimestamp(event.timestamp());

            repository.save(log); // Salva no MongoDB

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
