package com.example.enrollment_service.service;

import com.example.enrollment_service.clients.CourseService;
import com.example.enrollment_service.clients.StudentService;
import com.example.enrollment_service.dtoRecords.ResponseDto;
import com.example.enrollment_service.model.Enrollment;
import com.example.enrollment_service.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository repository;
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentServiceImpl(EnrollmentRepository repository, StudentService studentService, CourseService courseService) {
        this.repository = repository;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        return repository.save(enrollment);
    }

    @Override
    public List<Enrollment> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Enrollment> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Object findStudentDetails(Long id) {
        ResponseDto response = studentService.getStudentById(id);
        return response.response();
    }

    @Override
    public Object findCourseDetails(Long id) {
        Object response = courseService.getCourseById(id);
        System.err.println(response);
        return response;
    }
}