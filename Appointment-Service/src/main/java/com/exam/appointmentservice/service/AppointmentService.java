package com.exam.appointmentservice.service;

import com.exam.appointmentservice.DoctorResponse;
import com.exam.appointmentservice.dto.response.ApiResponse;
import com.exam.appointmentservice.exception.DoctorServiceUnavailableException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final RestTemplate restTemplate;

    @CircuitBreaker(
            name = "doctorServiceCB",
            fallbackMethod = "getDoctorFallback"
    )
    public DoctorResponse checkDoctor(Long doctorId) {

        return restTemplate.getForObject(
                "http://DOCTOR-SERVICE/api/v1/doctors/" + doctorId,
                DoctorResponse.class
        );
    }

    public DoctorResponse getDoctorFallback(
            Long doctorId,
            Throwable e
    ) {

        throw new DoctorServiceUnavailableException(e.getMessage());
    }
}
