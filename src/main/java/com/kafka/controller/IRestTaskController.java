package com.kafka.controller;

import java.util.List;

import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.TaskRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.TaskResponseDTO;
import com.kafka.dto.response.UserResponseDTO;

public interface IRestTaskController {

	public RootEntity<TaskResponseDTO> save(TaskRequestDTO taskRequestDTO);
	
	public RootEntity<TaskResponseDTO> update(Long id, TaskRequestDTO taskRequestDTO);
	
	public RootEntity<Long> delete(Long id);
	
	public RootEntity<TaskResponseDTO> findTaskById(Long id);
	
	public RootEntity<List<TaskResponseDTO>> getAllTasks();
	
	public RootEntity<RestPageableResponseDTO<TaskResponseDTO>> getPageableResponse(RestPageableRequestDTO restPageableRequestDTO);

}
