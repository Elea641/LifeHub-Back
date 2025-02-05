package com.LifeHub_Back.task.domain.shared.exception;

public class TaskValidationException extends RuntimeException {

    public TaskValidationException(String message) {
        super(message);
    }
}
