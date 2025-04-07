package com.example.enrollment_service.service;

import com.example.enrollment_service.model.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentService {

    Enrollment save(Enrollment enrollment);

    List<Enrollment> findAll();

    Optional<Enrollment> findById(Long id);

    Object findStudentDetails(Long studentId);

    Object findCourseDetails(Long courseId);
}
