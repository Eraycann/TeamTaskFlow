package com.kafka.controller;

import java.util.List;

import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.UserTaskRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.UserResponseDTO;
import com.kafka.dto.response.UserTaskResponseDTO;

public interface IRestUserTaskController {

	public RootEntity<UserTaskResponseDTO> save(UserTaskRequestDTO userTaskRequestDTO);
	
	public RootEntity<UserTaskResponseDTO> update(Long id, UserTaskRequestDTO userTaskRequestDTO);
	
	public RootEntity<Long> delete(Long id);
	
	public RootEntity<UserTaskResponseDTO> findUserTaskById(Long id);
	
	public RootEntity<List<UserTaskResponseDTO>> getAllUsersTasks();
	
	public RootEntity<RestPageableResponseDTO<UserTaskResponseDTO>> getPageableResponse(RestPageableRequestDTO restPageableRequestDTO);

}
