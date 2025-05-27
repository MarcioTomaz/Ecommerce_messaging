package com.example.ecommerce_messaging.mapper;

import com.example.ecommerce_messaging.model.OrderEvent;
import com.example.ecommerce_messaging.model.OrderLog;
import com.example.ecommerce_messaging.model.enums.AlteredByType;

public class OrderEventMapper {

    public static OrderLog toOrderLog(OrderEvent event) {

        OrderLog log = new OrderLog();
        log.setOrderId(event.orderId());
        log.setStatus(event.status().name());

        log.setAlteredByType(event.alteredByType());
        log.setExecutionType(event.executionType());

        if (event.refuseReason() != null && !event.refuseReason().isBlank()) {
            log.setRefuseReason(event.refuseReason());
        }

        if (event.alteredByType() == AlteredByType.USER && event.userLog() != null) {
            log.setUserLog(event.userLog());
        } else {
            log.setUserLog(null);
        }

        log.setTimestamp(event.timestamp());

        return log;
    }
}
