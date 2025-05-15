package com.example.ecommerce_messaging.repository;

import com.example.ecommerce_messaging.model.OrderLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLogRepository extends MongoRepository<OrderLog, String> {
}
