package com.example.ecommerce_messaging.consumer;

import com.example.ecommerce_messaging.model.DTO.ProductAvailabilityRequestDTO;
import com.example.ecommerce_messaging.model.ProductAvailabilityRequest;
import com.example.ecommerce_messaging.repository.ProductAvailabilityRequestRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductAvailabilityRequestConsumer {

    private final ProductAvailabilityRequestRepository productAvailabilityRequestRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "product.availability.request", groupId = "productAvailabilityRequest-group")
    public void listen(String message){

        try {
            ProductAvailabilityRequestDTO event = objectMapper.readValue(message, ProductAvailabilityRequestDTO.class);

            ProductAvailabilityRequestDTO result = productAvailabilityRequestRepository
                    .findByUserIdAndProductId(event.userId(), event.productId());

            //verifica se já possuí a solicitação do usuario para produto X
            if(result != null){
                return;
            }

            ProductAvailabilityRequest product = ProductAvailabilityRequest.builder()
                    .productId(event.productId())
                    .productName(event.product_name())
                    .userId(event.userId())
                    .timestamp(event.timestamp())
                    .build();

            productAvailabilityRequestRepository.save(product);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
