package com.example.ecommerce_messaging.consumer;

import com.example.ecommerce_messaging.model.ProductUpdateAuditDTO;
import com.example.ecommerce_messaging.repository.ProductUpdateAuditDTORepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductUpdateHistoryAuditConsumer {

    private final ProductUpdateAuditDTORepository repository;
    private final ObjectMapper objectMapper;


    @KafkaListener(topics = "product.update.history.audit", groupId = "pdtAudit-group")
    public void listen(String message) {

        try {

            ProductUpdateAuditDTO productUpdateAuditDTO = objectMapper.readValue(message, ProductUpdateAuditDTO.class);

            repository.save(productUpdateAuditDTO);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
