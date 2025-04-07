package com.edutrack.course_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
//import lombok.*;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class RequestDto {

    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotBlank(message = "Trainer name is mandatory")
    @JsonProperty("trainer_name")
    private String trainerName;

    public RequestDto(){}


    public @NotBlank(message = "Trainer name is mandatory") String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(@NotBlank(message = "Trainer name is mandatory") String trainerName) {
        this.trainerName = trainerName;
    }

    public @NotBlank(message = "Description is mandatory") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "Description is mandatory") String description) {
        this.description = description;
    }

    public @NotBlank(message = "Title is mandatory") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "Title is mandatory") String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RequestDto(String title, String description, String trainerName) {
        this.title = title;
        this.description = description;
        this.trainerName = trainerName;
    }


    public RequestDto( Long id,String title, String description, String trainerName) {
         this.id = id;
         this.title = title;
        this.description = description;
        this.trainerName = trainerName;
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", trainerName='" + trainerName + '\'' +
                '}';
    }


}
