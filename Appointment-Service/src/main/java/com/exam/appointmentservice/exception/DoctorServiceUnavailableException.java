package com.exam.appointmentservice.exception;

public class DoctorServiceUnavailableException extends RuntimeException {
    public DoctorServiceUnavailableException(String message) {
        super(message);
    }
}
