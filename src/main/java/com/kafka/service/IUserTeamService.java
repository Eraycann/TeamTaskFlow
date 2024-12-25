package com.kafka.service;

import java.util.List;

import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.UserTeamRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.UserResponseDTO;
import com.kafka.dto.response.UserTeamResponseDTO;

public interface IUserTeamService {

	// save update delete findTeamById getAllTeams

	public UserTeamResponseDTO save(UserTeamRequestDTO userTeamRequestDTO);
	
	public UserTeamResponseDTO update(Long id, UserTeamRequestDTO userTeamRequestDTO);
	
	public Long delete(Long id);
	
	public UserTeamResponseDTO findUserTeamById(Long id);
	
	public List<UserTeamResponseDTO> getAllUsersTeams();
	
	public RestPageableResponseDTO<UserTeamResponseDTO> getPageableResponse(RestPageableRequestDTO restPageableRequestDTO);

}
