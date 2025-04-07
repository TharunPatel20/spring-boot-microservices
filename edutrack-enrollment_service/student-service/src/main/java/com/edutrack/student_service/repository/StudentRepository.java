package com.edutrack.student_service.repository;

import com.edutrack.student_service.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
