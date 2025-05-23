package com.example.enrollment_service.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("COURSE-SERVICE")
public interface CourseService {

    @GetMapping("/courses/{id}")
    Object getCourseById(@PathVariable Long id);
}
