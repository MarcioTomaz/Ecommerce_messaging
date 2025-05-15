package com.example.ecommerce_messaging.model.enums;


import lombok.Getter;

@Getter
public enum OrderStatus {
    PENDING("Pendente"),
    PROCESSING("Em Processamento"),
    WAITING_FOR_PAYMENT("Aguardando Pagamento"),
    PAID("Pago"),
    SHIPPED("Enviado"),
    DELIVERED("Entregue"),
    CANCELED("Cancelado");



    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }
}
