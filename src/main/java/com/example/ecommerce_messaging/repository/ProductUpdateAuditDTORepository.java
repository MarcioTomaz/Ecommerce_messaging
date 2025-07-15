package com.example.ecommerce_messaging.repository;

import com.example.ecommerce_messaging.model.ProductUpdateAuditDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductUpdateAuditDTORepository extends MongoRepository<ProductUpdateAuditDTO, String> {
}
