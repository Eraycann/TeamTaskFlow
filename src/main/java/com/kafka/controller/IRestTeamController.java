package com.kafka.controller;

import java.util.List;

import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.TeamRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.TeamResponseDTO;
import com.kafka.dto.response.UserResponseDTO;

public interface IRestTeamController {

	// save update delete findTeamById getAllTeams

	public RootEntity<TeamResponseDTO> save(TeamRequestDTO teamRequestDTO);
	
	public RootEntity<TeamResponseDTO> update(Long id ,TeamRequestDTO teamRequestDTO);
	
	public RootEntity<Long> delete(Long id);
	
	public RootEntity<TeamResponseDTO> findTeamById(Long id);
	
	public RootEntity<List<TeamResponseDTO>> getAllTeams();
	
	public RootEntity<RestPageableResponseDTO<TeamResponseDTO>> getPageableResponse(RestPageableRequestDTO restPageableRequestDTO);

}
