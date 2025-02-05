package com.LifeHub_Back.configuration.application.shared.exception;

import com.LifeHub_Back.configuration.application.shared.dto.ErrorResponse;
import com.LifeHub_Back.task.domain.shared.exception.TaskValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TaskValidationException.class)
    public ResponseEntity<ErrorResponse> handleTaskValidationException(TaskValidationException e) {
        ErrorResponse errorResponse = new ErrorResponse("Validation error", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        String errorMessage = ex.getMessage();

        if (ex instanceof IllegalArgumentException) {
            errorMessage = ex.getMessage().replace("java.lang.", "");
        }

        ErrorResponse errorResponse = new ErrorResponse("Une erreur interne est survenue", errorMessage);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
