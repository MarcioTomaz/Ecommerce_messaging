package com.example.ecommerce_messaging.model;

import com.example.ecommerce_messaging.model.enums.UserRole;

public record UserPersonLOG(String email, String name, Long Id, UserRole userRole) {
}
