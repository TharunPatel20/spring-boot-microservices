package com.edutrack.course_service.controller;

import com.edutrack.course_service.dto.RequestDto;
import com.edutrack.course_service.dto.ResponseDto;
import com.edutrack.course_service.model.Course;
import com.edutrack.course_service.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseRepository) {
        this.courseService = courseRepository;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseDto> createCourse(@Valid @RequestBody RequestDto dto) {
        var course = new Course(dto.getTitle(),dto.getDescription(),dto.getTrainerName());
        System.out.println(dto+"\n"+course);
        course = courseService.save(course);
        dto.setId(course.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(getResponseDto(HttpStatus.CREATED,dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<ResponseDto> getAllCourses() {
        var courses = courseService.findAll();
        if (courses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok( getResponseDto(HttpStatus.OK,courses));
    }

    public static ResponseDto getResponseDto(HttpStatus status,Object response ){
        return new ResponseDto(status,response);
    }
}
