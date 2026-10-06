package com.exam.appointmentservice.exception;

import com.exam.appointmentservice.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DoctorServiceUnavailableException.class)
    public ResponseEntity<ApiResponse> handleDoctorServiceUnavailable(
            DoctorServiceUnavailableException exception
    ) {

        ApiResponse response = new ApiResponse(
                HttpStatus.SERVICE_UNAVAILABLE.value(),
                exception.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(response);
    }
}
