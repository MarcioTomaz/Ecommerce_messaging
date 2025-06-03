package com.example.ecommerce_messaging.repository;

import com.example.ecommerce_messaging.model.DTO.ProductAvailabilityRequestDTO;
import com.example.ecommerce_messaging.model.ProductAvailabilityRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductAvailabilityRequestRepository
        extends MongoRepository<ProductAvailabilityRequest, String> {

    ProductAvailabilityRequestDTO findByUserIdAndProductId(Long userId, Long productId);


    List<ProductAvailabilityRequest> findByProductId(Long productId);

}
