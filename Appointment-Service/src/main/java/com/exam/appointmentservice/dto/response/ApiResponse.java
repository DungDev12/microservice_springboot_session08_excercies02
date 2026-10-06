package com.exam.appointmentservice.dto.response;

public record ApiResponse(
        int status,
        String message
) {
}
