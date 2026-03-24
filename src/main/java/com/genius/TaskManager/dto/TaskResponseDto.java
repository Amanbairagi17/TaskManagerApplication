package com.genius.TaskManager.dto;

import com.genius.TaskManager.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
public class TaskResponseDto {
    private long id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDate createdAt;
}
