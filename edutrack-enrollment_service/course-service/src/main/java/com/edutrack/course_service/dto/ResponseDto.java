package com.edutrack.course_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private HttpStatus status;
    private Object response;

    public ResponseDto(){}
    public ResponseDto(HttpStatus status, Object response){
        this.status=status;
        this.response=response;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
