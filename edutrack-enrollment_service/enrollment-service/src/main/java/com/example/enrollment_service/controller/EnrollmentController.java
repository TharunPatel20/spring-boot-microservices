package com.example.enrollment_service.controller;

import com.example.enrollment_service.dtoRecords.RequestDto;
import com.example.enrollment_service.dtoRecords.ResponseDto;
import com.example.enrollment_service.model.Enrollment;
import com.example.enrollment_service.service.EnrollmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
    final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> enrollStudent(@Valid @RequestBody RequestDto dto) {
        var enrollment = new Enrollment(dto.studentId(),dto.courseId());
        Object savedEnrollment = enrollmentService.save(enrollment);
        var response = new ResponseDto(HttpStatus.CREATED,savedEnrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findEnrollment(@PathVariable Long id) {
        var enrollment = enrollmentService.findById(id).orElseThrow();
        var response = new ResponseDto(HttpStatus.OK,enrollment);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<ResponseDto> findAllEnrollments() {
        var enrollments = enrollmentService.findAll();
        if (enrollments.isEmpty()) {
            var response = new ResponseDto(HttpStatus.NO_CONTENT, List.of());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }
        var response = new ResponseDto(HttpStatus.OK,enrollments);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // GET /details/{id}
    @GetMapping("/{id}/details")
    public ResponseEntity<ResponseDto> findEnrollmentDetails(@PathVariable Long id){
        var enrollment = enrollmentService.findById(id).orElseThrow();
        var studentId = enrollment.getStudentId();
        var courseId = enrollment.getCourseId();

        var studentDetails =  enrollmentService.findStudentDetails(studentId);
        var courseDetails = enrollmentService.findCourseDetails(courseId);

        HashMap<String, Object> payload = new HashMap<>();
        payload.put("enrollment", enrollment);
        payload.put("student", studentDetails);
        payload.put("course", courseDetails);

        var response = new ResponseDto(HttpStatus.OK,payload);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
