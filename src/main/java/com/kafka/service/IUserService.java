package com.kafka.service;

import java.util.List;

import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.UserRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.UserResponseDTO;

public interface IUserService {

//	public UserResponseDTO saveUser(UserRequestDTO userRequestDTO);
	
	public UserResponseDTO updateUser(Long userId, UserRequestDTO userRequestDTO);

	public Long deleteUser(Long userId);
	
	public UserResponseDTO findUserById(Long userId);
	
	public List<UserResponseDTO> getAllUsers();
	
	public RestPageableResponseDTO<UserResponseDTO> getPageableResponse(RestPageableRequestDTO restPageableRequestDTO);
}
