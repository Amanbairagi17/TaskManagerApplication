package com.genius.TaskManager.mapper.impl;

import com.genius.TaskManager.dto.TaskUpdateDto;
import com.genius.TaskManager.entity.TaskModel;
import com.genius.TaskManager.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskUpdateDtoMapper implements Mapper<TaskModel, TaskUpdateDto> {

    private final ModelMapper modelMapper;

    @Override
    public TaskUpdateDto mapTo(TaskModel taskModel) {
        return modelMapper.map(taskModel, TaskUpdateDto.class);
    }

    @Override
    public TaskModel mapFrom(TaskUpdateDto updateDto) {
        return modelMapper.map(updateDto, TaskModel.class);
    }
}
