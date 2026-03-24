package com.genius.TaskManager.mapper.impl;

import com.genius.TaskManager.dto.TaskResponseDto;
import com.genius.TaskManager.entity.TaskModel;
import com.genius.TaskManager.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskResponseMapper implements Mapper<TaskModel, TaskResponseDto> {

    private final ModelMapper modelMapper;

    @Override
    public TaskResponseDto mapTo(TaskModel taskModel) {
        return modelMapper.map(taskModel, TaskResponseDto.class);
    }

    @Override
    public TaskModel mapFrom(TaskResponseDto taskResponseDto) {
        return modelMapper.map(taskResponseDto, TaskModel.class);
    }
}
