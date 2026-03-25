package com.genius.TaskManager.controller;

import com.genius.TaskManager.dto.TaskRequestDto;
import com.genius.TaskManager.dto.TaskResponseDto;
import com.genius.TaskManager.dto.TaskUpdateDto;
import com.genius.TaskManager.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable long id){
        TaskResponseDto response = taskService.findTaskById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable long id){
        String response = taskService.deleteTask(id);
        System.out.println(response);
        return ResponseEntity.ok(response);

        //return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<TaskResponseDto> updateById(@PathVariable long id, @RequestBody TaskUpdateDto updateDto){
        TaskResponseDto response = taskService.updateTask(id, updateDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/get-all-task")
    public ResponseEntity<List<TaskResponseDto>> getAllTask(){
        List<TaskResponseDto> responseList = taskService.findAllTask();
        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }
//    @PutMapping("update-status/{id}")
//    public ResponseEntity<TaskResponseDto> updateTaskStatus(@PathVariable long id, )
}
