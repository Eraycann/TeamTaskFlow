package com.kafka.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.kafka.dto.request.TaskRequestDTO;
import com.kafka.dto.response.TaskResponseDTO;
import com.kafka.model.Task;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface TaskMapper {

	TaskResponseDTO entity
}
