package com.example.ecommerce_messaging.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;


@Document(collection = "order_logs")
public class OrderLog {

    @Id
    private String id;

    private Long orderId;
    private String status;
    private UserPersonLOG userLog;
    private Instant timestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public UserPersonLOG getUserLog() {
        return userLog;
    }

    public void setUserLog(UserPersonLOG userLog) {
        this.userLog = userLog;
    }
}
