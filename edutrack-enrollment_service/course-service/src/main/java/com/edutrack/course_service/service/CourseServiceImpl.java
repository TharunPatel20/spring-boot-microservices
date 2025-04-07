package com.edutrack.course_service.service;

import com.edutrack.course_service.model.Course;
import com.edutrack.course_service.repository.CourseRepository;
import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(rollbackOn = MethodArgumentNotValidException.class)
    public Course save(Course course) {
        return repository.save(course);
    }

    @Override
    public Optional<Course> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }
}
