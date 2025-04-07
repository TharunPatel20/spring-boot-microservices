package com.edutrack.student_service.service;

import com.edutrack.student_service.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student save(Student student);
    Optional<Student> findById(Long id);
    List<Student> findAll();
}
