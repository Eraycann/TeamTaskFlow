package com.kafka.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.kafka.dto.request.TaskRequestDTO;
import com.kafka.dto.response.TaskResponseDTO;
import com.kafka.model.Task;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface TaskMapper {

    TaskResponseDTO entityToTaskResponseDTO(Task task);
    
    // Create
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "assignedBy", ignore = true) // Göz ardı et, veritabanındaki 'assigned_by' ile ilişkilendirilecek
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Task TaskRequestDTOToEntity(TaskRequestDTO taskRequestDTO);

    List<TaskResponseDTO> entitiesToTaskResponseDTOs(List<Task> tasks);
    
    // Update
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "assignedBy", ignore = true) // Göz ardı et
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void TaskRequestDTOToEntity(TaskRequestDTO taskRequestDTO, @MappingTarget Task task);
}
