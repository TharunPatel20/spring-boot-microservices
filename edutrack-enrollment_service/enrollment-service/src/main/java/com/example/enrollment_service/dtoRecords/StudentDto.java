package com.example.enrollment_service.dtoRecords;

public record StudentDto(
        Long id,
        String name,
        String email,
        String enrolledCourse
){}