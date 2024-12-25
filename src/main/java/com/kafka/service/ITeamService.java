package com.kafka.service;

import java.util.List;

import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.TeamRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.TeamResponseDTO;
import com.kafka.dto.response.UserResponseDTO;

public interface ITeamService {

	// save update delete findTeamById getAllTeams
	
	public TeamResponseDTO save(TeamRequestDTO teamRequestDTO);
	
	public TeamResponseDTO update(Long id, TeamRequestDTO teamRequestDTO);
	
	public Long delete(Long id);
	
	public TeamResponseDTO findTeamById(Long id);
	
	public List<TeamResponseDTO> getAllTeams();
	
	public RestPageableResponseDTO<TeamResponseDTO> getPageableResponse(RestPageableRequestDTO restPageableRequestDTO);

}
