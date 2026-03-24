package com.genius.TaskManager.mapper.impl;

import com.genius.TaskManager.dto.TaskRequestDto;
import com.genius.TaskManager.entity.TaskModel;
import com.genius.TaskManager.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskRequestMapper implements Mapper<TaskModel, TaskRequestDto> {

    private final ModelMapper modelMapper;

    @Override
    public TaskRequestDto mapTo(TaskModel taskModel) {
        return modelMapper.map(taskModel, TaskRequestDto.class);
    }

    @Override
    public TaskModel mapFrom(TaskRequestDto taskRequestDto) {
        return modelMapper.map(taskRequestDto, TaskModel.class);
    }
}
