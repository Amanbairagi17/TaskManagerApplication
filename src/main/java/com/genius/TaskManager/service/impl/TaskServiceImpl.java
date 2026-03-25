package com.genius.TaskManager.service.impl;

import com.genius.TaskManager.dto.TaskRequestDto;
import com.genius.TaskManager.dto.TaskResponseDto;
import com.genius.TaskManager.dto.TaskUpdateDto;
import com.genius.TaskManager.entity.TaskModel;
import com.genius.TaskManager.mapper.Mapper;
import com.genius.TaskManager.repository.TaskRepository;
import com.genius.TaskManager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final Mapper<TaskModel, TaskRequestDto> requestDtoMapper;
    private final Mapper<TaskModel, TaskResponseDto> responseDtoMapper;
    private final Mapper<TaskModel, TaskUpdateDto> updateDtoMapper;

    @Override
    public TaskResponseDto findTaskById(long id) {
        TaskModel response = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found!!"));

        return responseDtoMapper.mapTo(response);
    }

    @Override
    public TaskResponseDto createNewTask(TaskRequestDto taskRequestDto) {
        TaskModel task = requestDtoMapper.mapFrom(taskRequestDto);
        TaskModel savedTask = taskRepository.save(task);
        System.out.println(savedTask.toString());

        return responseDtoMapper.mapTo(savedTask);
    }

    @Override
    public TaskResponseDto updateTask(long id, TaskUpdateDto updateDto) {
        TaskModel response = taskRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Task not available with id : " +id);
        });

        response.setDescription(updateDto.getDescription());
        response.setStatus(updateDto.getStatus());

        return responseDtoMapper.mapTo(response);
    }

    @Override
    public List<TaskResponseDto> findAllTask() {
        List<TaskResponseDto> responseList  = new ArrayList<>();
        List<TaskModel> taskModelList = taskRepository.findAll();

        for(TaskModel task : taskModelList){
            responseList.add(responseDtoMapper.mapTo(task));
        }
        return responseList;
    }

    @Override
    public String deleteTask(long id) {
        TaskModel response = taskRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Task not found!!");
        });
        taskRepository.deleteById(id);

        return "Task deleted successfully with id : "+id;
    }
}
