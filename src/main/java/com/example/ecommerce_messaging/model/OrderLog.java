package com.example.ecommerce_messaging.model;

import com.example.ecommerce_messaging.model.enums.AlteredByType;
import com.example.ecommerce_messaging.model.enums.ExecutionType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;


@Getter
@Setter
@Document(collection = "order_logs")
public class OrderLog {

    @Id
    private String id;

    private Long orderId;
    private String status;
    private String refuseReason;
    private UserPersonLOG userLog;

    private AlteredByType alteredByType;
    private ExecutionType executionType;

    private Instant timestamp;
}
