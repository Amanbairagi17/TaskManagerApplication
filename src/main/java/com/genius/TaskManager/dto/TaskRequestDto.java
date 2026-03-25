package com.genius.TaskManager.dto;

import com.genius.TaskManager.enums.TaskStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskRequestDto {
    @NotEmpty @Size(min = 4, max = 20, message = "Title length between 4 to 20 character")
    private String title;

    @NotEmpty
    private String description;

    @NotNull
    private TaskStatus status;

}
