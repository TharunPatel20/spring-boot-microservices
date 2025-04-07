package com.edutrack.student_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;


public class ResponseDto {
    private HttpStatus status;
    @JsonProperty("response")
    private Object payload;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public ResponseDto(HttpStatus status, Object payload) {
        this.status = status;
        this.payload = payload;
    }
}
