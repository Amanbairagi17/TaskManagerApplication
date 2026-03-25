package com.genius.TaskManager.service;

import com.genius.TaskManager.dto.TaskRequestDto;
import com.genius.TaskManager.dto.TaskResponseDto;
import com.genius.TaskManager.dto.TaskUpdateDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    TaskResponseDto createNewTask(TaskRequestDto taskRequestDto);

    TaskResponseDto findTaskById(long id);

    String deleteTask(long id);

    TaskResponseDto updateTask(long id, TaskUpdateDto updateDto);

    List<TaskResponseDto> findAllTask();
}
