package com.edutrack.student_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "course-service", url = "http://10.9.236.120:8099/")
public interface CourseClient{
@GetMapping("/courses/{id}")
    ResponseEntity<?> getCourseById(@PathVariable Long id);
    @GetMapping("/courses")
    ResponseEntity<?> getAllCourses();
}
