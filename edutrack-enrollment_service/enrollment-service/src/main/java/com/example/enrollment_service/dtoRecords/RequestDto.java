package com.example.enrollment_service.dtoRecords;

import jakarta.validation.constraints.NotNull;

public record RequestDto(@NotNull Long studentId,@NotNull Long courseId) {
}
