package com.genius.TaskManager.dto;

import com.genius.TaskManager.enums.TaskStatus;
import lombok.Data;

@Data
public class TaskUpdateDto {
    private String description;
    private TaskStatus status;
}
