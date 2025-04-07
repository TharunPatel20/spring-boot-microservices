package com.example.enrollment_service.dtoRecords;

import org.springframework.http.HttpStatus;

public record ResponseDto(HttpStatus status,Object response) {
}
