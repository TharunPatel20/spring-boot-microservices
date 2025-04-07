package com.example.enrollment_service.clients;

import com.example.enrollment_service.dtoRecords.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("STUDENT-SERVICE")
public interface StudentService {

    @GetMapping("/students/{id}")
    ResponseDto getStudentById(@PathVariable Long id);
}