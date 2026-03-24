package com.genius.TaskManager.controller;

import com.genius.TaskManager.dto.TaskRequestDto;
import com.genius.TaskManager.dto.TaskResponseDto;
import com.genius.TaskManager.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDto> createTask(@Valid @RequestBody TaskRequestDto taskRequestDto){
        TaskResponseDto response = taskService.createNewTask(taskRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
