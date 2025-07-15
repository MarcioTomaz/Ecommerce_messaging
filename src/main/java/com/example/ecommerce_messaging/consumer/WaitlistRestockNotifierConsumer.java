package com.example.ecommerce_messaging.consumer;


import com.example.ecommerce_messaging.model.DTO.ProductStockUpdateDTO;
import com.example.ecommerce_messaging.model.Notification;
import com.example.ecommerce_messaging.model.ProductAvailabilityRequest;
import com.example.ecommerce_messaging.model.enums.NotificationType;
import com.example.ecommerce_messaging.model.enums.ReferenceType;
import com.example.ecommerce_messaging.producer.NotificationProducerService;
import com.example.ecommerce_messaging.repository.ProductAvailabilityRequestRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WaitlistRestockNotifierConsumer {

    private final ObjectMapper objectMapper;
    private final ProductAvailabilityRequestRepository productAvailabilityRequestRepository;

    private final NotificationProducerService notificationProducerService;

    @KafkaListener(topics = "waitlist.restock.notifier", groupId = "waitlistRestockNotifier-group")
    public void listen(String message) {
        try {

            ProductStockUpdateDTO event = objectMapper.readValue(message, ProductStockUpdateDTO.class);

            List<ProductAvailabilityRequest> result = productAvailabilityRequestRepository.findByProductId(event.productId());

            result.forEach(pdt -> {

                Notification ntf = new Notification(
                        null,
                        event.userId(),
                        "Product Restock Update",
                        "Product Restock Update",
                        false,
                        NotificationType.StockUpdate,
                        pdt.getProductId(),
                        ReferenceType.STOCK,
                        Instant.now()
                );

                notificationProducerService.sendNotification(ntf);
            });

            productAvailabilityRequestRepository.deleteAll(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
