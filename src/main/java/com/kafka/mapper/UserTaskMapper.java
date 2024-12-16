package com.kafka.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.kafka.dto.response.UserTaskResponseDTO;
import com.kafka.model.UserTask;

@Mapper(componentModel = "spring", uses = {UserMapper.class, TaskMapper.class, RoleMapper.class })
public interface UserTaskMapper {

	UserTaskResponseDTO entityToUserTaskResponseDTO(UserTask userTask);
	
	
}
