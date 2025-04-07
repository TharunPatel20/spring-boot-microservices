package com.edutrack.student_service.controller;

import com.edutrack.student_service.dto.RequestDto;
import com.edutrack.student_service.dto.ResponseDto;
import com.edutrack.student_service.model.Student;
import com.edutrack.student_service.service.StudentService;
import com.edutrack.student_service.service.StudentServiceImpl;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl service) {
        this.studentService = service;
    }
    record RequestRecordDto(
            Long id, @NotBlank(message = "Name is mandatory") String name,
            @NotBlank(message = "Email is mandatory") @Email(message = "Email should be valid") String email,
            @NotBlank(message = "Enrolled course is mandatory") @JsonProperty("enrolled_course") String enrolledCourse
    ){}

    @PostMapping
    public ResponseEntity<ResponseDto> createCourse(@Valid @RequestBody RequestRecordDto dto) {
//        var student = new Student(dto.getName(),dto.getEmail(),dto.getEnrolledCourse());
        var student = new Student(dto.name, dto.email, dto.enrolledCourse);
        student = studentService.save(student);
//        dto.setId(student.getId());


        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED,dto));
//                ResponseDto.builder()
//                        .status(HttpStatus.CREATED)
//                        .payload(dto).build()
//        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getCourseById(@PathVariable Long id) {
        return studentService.findById(id)
                .map(student -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(
                                new ResponseDto(HttpStatus.OK,student)
                        )
                )
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<ResponseDto> getAllCourses() {
        var students = studentService.findAll();
        if (students.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                    new ResponseDto(HttpStatus.OK,List.of())
//                    ResponseDto.builder().status(HttpStatus.NO_CONTENT).payload(List.of()).build()
            );
        }
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK,students));
    }

    // course endpoints

    @GetMapping("/courses")
    public ResponseEntity<?> getCourses(){
        return studentService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<?> getCourses(@PathVariable Long id){
        return studentService.getCourseById(id);
    }

}
