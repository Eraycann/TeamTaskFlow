package com.kafka.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.kafka.dto.request.UserTaskRequestDTO;
import com.kafka.dto.response.UserTaskResponseDTO;
import com.kafka.model.UserTask;

@Mapper(componentModel = "spring", uses = {UserMapper.class, TaskMapper.class, RoleMapper.class })
public interface UserTaskMapper {

	UserTaskResponseDTO entityToUserTaskResponseDTO(UserTask userTask);
	
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "task", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
	UserTask userTaskRequestDTOToEntity(UserTaskRequestDTO userTaskRequestDTO);
    
    List<UserTaskResponseDTO> entitiesToUserTaskResponseDTOs(List<UserTask> userTasks);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "task", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
	void userTaskRequestDTOToEntity(UserTaskRequestDTO userTaskRequestDTO, @MappingTarget UserTask userTask);
}
 