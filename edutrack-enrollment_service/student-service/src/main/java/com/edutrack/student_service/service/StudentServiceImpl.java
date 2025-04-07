package com.edutrack.student_service.service;

import com.edutrack.student_service.feign.CourseClient;
import com.edutrack.student_service.model.Student;
import com.edutrack.student_service.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private  StudentRepository repository;

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }



    // course-services that calls course endpoints via feign client
    @Autowired
    private CourseClient courseClient;

    public ResponseEntity<?> getCourseById(Long id) {
        return courseClient.getCourseById(id);
    }

    public ResponseEntity<?> getAllCourses() {
        return courseClient.getAllCourses();
    }
}
