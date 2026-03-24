package com.genius.TaskManager.service;

import com.genius.TaskManager.dto.TaskRequestDto;
import com.genius.TaskManager.dto.TaskResponseDto;
import org.springframework.http.ResponseEntity;

public interface TaskService {
    TaskResponseDto createNewTask(TaskRequestDto taskRequestDto);
}
