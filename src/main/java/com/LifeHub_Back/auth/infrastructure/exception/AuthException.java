package com.LifeHub_Back.auth.infrastructure.exception;

public class AuthException extends RuntimeException{
    public AuthException(String message) {
        super(message);
    }
}
