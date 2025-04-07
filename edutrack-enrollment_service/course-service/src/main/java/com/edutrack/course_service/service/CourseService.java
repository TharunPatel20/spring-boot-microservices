package com.edutrack.course_service.service;

import com.edutrack.course_service.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Course save(Course course);
    Optional<Course> findById(long id);
    List<Course> findAll();
}
