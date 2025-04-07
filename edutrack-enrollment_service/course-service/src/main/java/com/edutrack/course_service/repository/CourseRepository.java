package com.edutrack.course_service.repository;

import com.edutrack.course_service.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
