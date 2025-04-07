package com.edutrack.student_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RequestDto {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Enrolled course is mandatory")
    @JsonProperty("enrolled_course")
    private String enrolledCourse;


    public RequestDto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Name is mandatory") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is mandatory") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Email is mandatory") @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is mandatory") @Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Enrolled course is mandatory") String getEnrolledCourse() {
        return enrolledCourse;
    }

    public void setEnrolledCourse(@NotBlank(message = "Enrolled course is mandatory") String enrolledCourse) {
        this.enrolledCourse = enrolledCourse;
    }

    public RequestDto(Long id, String enrolledCourse, String email, String name) {
        this.id = id;
        this.enrolledCourse = enrolledCourse;
        this.email = email;
        this.name = name;
    }

    public RequestDto(String enrolledCourse, String email, String name) {
        this.enrolledCourse = enrolledCourse;
        this.email = email;
        this.name = name;
    }
}
