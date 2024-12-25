package com.kafka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.TeamRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.TeamResponseDTO;
import com.kafka.exception.BaseException;
import com.kafka.exception.ErrorMessage;
import com.kafka.exception.MessageType;
import com.kafka.mapper.TeamMapper;
import com.kafka.mapper.UserMapper;
import com.kafka.model.Team;
import com.kafka.model.User;
import com.kafka.repository.TeamRepository;
import com.kafka.repository.UserRepository;
import com.kafka.service.ITeamService;
import com.kafka.utils.PagerUtil;

@Service
public class TeamServiceImpl implements ITeamService{

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private TeamMapper teamMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	private Team createTeam(TeamRequestDTO teamRequestDTO) {
		return teamMapper.TeamRequestDTOToEntity(teamRequestDTO);
	}
	
	private Team getTeamById(Long id) {
		return teamRepository.findById(id).orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString())));
	}
	
	private User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString())));
	}
	
	@Override
	public TeamResponseDTO save(TeamRequestDTO teamRequestDTO) {
		Team team = createTeam(teamRequestDTO);
		team.setOwner(getUserById(teamRequestDTO.getOwner()));
		Team savedTeam = teamRepository.save(team);
		return teamMapper.entityToTeamResponseDTO(savedTeam);
	}

	@Override
	public TeamResponseDTO update(Long id, TeamRequestDTO teamRequestDTO) {
		Team teamToUpdate = getTeamById(id);
		teamMapper.TeamRequestDTOToEntity(teamRequestDTO, teamToUpdate);
		teamToUpdate.setOwner(getUserById(teamRequestDTO.getOwner()));
		Team updatedTeam = teamRepository.save(teamToUpdate);
		return teamMapper.entityToTeamResponseDTO(updatedTeam);
	}

	@Override
	public Long delete(Long id) {
		teamRepository.delete(getTeamById(id));
		return id;
	}

	@Override
	public TeamResponseDTO findTeamById(Long id) {
		return teamMapper.entityToTeamResponseDTO(getTeamById(id));
	}

	@Override
	public List<TeamResponseDTO> getAllTeams() {
		return teamMapper.entititesTeamResponseDTOs(teamRepository.findAll());
	}

	@Override
	public RestPageableResponseDTO<TeamResponseDTO> getPageableResponse(RestPageableRequestDTO restPageableRequestDTO) {
		Page<Team> page = teamRepository.findAllPageable(PagerUtil.toPageable(restPageableRequestDTO));
		List<TeamResponseDTO> teamResponseDTOs = teamMapper.entititesTeamResponseDTOs(page.getContent());
		return PagerUtil.toPageableResponse(page, teamResponseDTOs);
	}	
}
