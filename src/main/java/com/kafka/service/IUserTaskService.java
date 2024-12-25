package com.kafka.service;

import java.util.List;

import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.UserTaskRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.UserResponseDTO;
import com.kafka.dto.response.UserTaskResponseDTO;

public interface IUserTaskService {

	// save update delete findTeamById getAllTeams

	public UserTaskResponseDTO save(UserTaskRequestDTO userTaskRequestDTO);
	
	public UserTaskResponseDTO update(Long id, UserTaskRequestDTO userTaskRequestDTO);
	
	public Long delete(Long id);
	
	public UserTaskResponseDTO findUserTaskById(Long id);

	public List<UserTaskResponseDTO> getAllUsersTasks();

	public RestPageableResponseDTO<UserTaskResponseDTO> getPageableResponse(RestPageableRequestDTO restPageableRequestDTO);

}
