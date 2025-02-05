package com.LifeHub_Back.configuration.application.shared.dto;

import org.springframework.beans.factory.annotation.Autowired;

public class ErrorResponse {
    private String message;
    private String details;

    @Autowired
    public ErrorResponse(String message, String details) {
        this.message = message;
        this.details = details;
    }

    // Getters et Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
