package com.kafka.controller;

import java.util.List;

import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.UserTeamRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.UserResponseDTO;
import com.kafka.dto.response.UserTeamResponseDTO;

public interface IRestUserTeamController {

	// save update delete findTeamById getAllTeams

	public RootEntity<UserTeamResponseDTO> save(UserTeamRequestDTO userTeamRequestDTO);
	
	public RootEntity<UserTeamResponseDTO> update(Long id, UserTeamRequestDTO userTeamRequestDTO);
	
	public RootEntity<Long> delete(Long id);
	
	public RootEntity<UserTeamResponseDTO> findUserTeamById(Long id);
	
	public RootEntity<List<UserTeamResponseDTO>> getAllUsersTeams();
	
	public RootEntity<RestPageableResponseDTO<UserTeamResponseDTO>> getPageableResponse(RestPageableRequestDTO restPageableRequestDTO);

}
