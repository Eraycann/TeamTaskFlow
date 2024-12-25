package com.kafka.controller;

import java.util.List;

import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.UserRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.UserResponseDTO;

public interface IRestUserController {

	public RootEntity<UserResponseDTO> updateUser(Long userId, UserRequestDTO userRequestDTO);

	public RootEntity<Long> deleteUser(Long userId);

	public RootEntity<UserResponseDTO> findUserById(Long userId);

	public RootEntity<List<UserResponseDTO>> getAllUsers();
	
	public RootEntity<RestPageableResponseDTO<UserResponseDTO>> getPageableResponse(RestPageableRequestDTO restPageableRequestDTO);
}
