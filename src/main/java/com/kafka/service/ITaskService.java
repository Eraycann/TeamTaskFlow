package com.kafka.service;

import java.util.List;

import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.TaskRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.TaskResponseDTO;
import com.kafka.dto.response.UserResponseDTO;

public interface ITaskService {
	
	// save update delete findTeamById getAllTeams

	public TaskResponseDTO save(TaskRequestDTO taskRequestDTO);
	
	public TaskResponseDTO update(Long id, TaskRequestDTO taskRequestDTO);
	
	public Long delete(Long id);
	
	public TaskResponseDTO findTaskById(Long id);
	
	public List<TaskResponseDTO> getAllTasks();
	
	public RestPageableResponseDTO<TaskResponseDTO> getPageableResponse(RestPageableRequestDTO restPageableRequestDTO);

}
