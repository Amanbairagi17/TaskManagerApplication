package com.genius.TaskManager.service.impl;

import com.genius.TaskManager.dto.TaskRequestDto;
import com.genius.TaskManager.dto.TaskResponseDto;
import com.genius.TaskManager.entity.TaskModel;
import com.genius.TaskManager.mapper.Mapper;
import com.genius.TaskManager.repository.TaskRepository;
import com.genius.TaskManager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final Mapper<TaskModel, TaskRequestDto> requestDtoMapper;
    private final Mapper<TaskModel, TaskResponseDto> responseDtoMapper;

    @Override
    public TaskResponseDto createNewTask(TaskRequestDto taskRequestDto) {
        TaskModel task = requestDtoMapper.mapFrom(taskRequestDto);
        TaskModel savedTask = taskRepository.save(task);
        System.out.println(savedTask.toString());

        return responseDtoMapper.mapTo(savedTask);
    }
}
