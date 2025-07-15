package com.example.ecommerce_messaging.model.DTO;

public record ProductStockUpdateDTO(
        Long userId,
        Long productId,
        Integer version,
        Long quantity
){
}
