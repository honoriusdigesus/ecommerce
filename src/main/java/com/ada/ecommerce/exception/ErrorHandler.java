package com.ada.ecommerce.exception;

import com.ada.ecommerce.exception.response.ErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(Exception ex){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = ErrorResponse.builder()
                .code(status.value())
                .error(status.name())
                .message(ex.getMessage())
                .build();
        return ResponseEntity
                .status(status)
                .body(error);
    }

    @ExceptionHandler(EmailAlreadyTaken.class)
    public ResponseEntity<ErrorResponse> handleEmailAlreadyTaken(Exception ex){
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorResponse error = ErrorResponse.builder()
                .code(status.value())
                .error(status.name())
                .message(ex.getMessage())
                .build();
        return ResponseEntity
                .status(status)
                .body(error);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorResponse> handleAuthenticationException(Exception ex){
        HttpStatus status = HttpStatus.FORBIDDEN;
        ErrorResponse error = ErrorResponse.builder()
                .code(status.value())
                .error(status.name())
                .message(ex.getMessage())
                .build();
        return ResponseEntity
                .status(status)
                .body(error);
    }
}
