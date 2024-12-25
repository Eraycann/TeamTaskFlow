package com.kafka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.UserTeamRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.UserTeamResponseDTO;
import com.kafka.exception.BaseException;
import com.kafka.exception.ErrorMessage;
import com.kafka.exception.MessageType;
import com.kafka.mapper.UserTeamMapper;
import com.kafka.model.Role;
import com.kafka.model.Team;
import com.kafka.model.User;
import com.kafka.model.UserTeam;
import com.kafka.repository.RoleRepository;
import com.kafka.repository.TeamRepository;
import com.kafka.repository.UserRepository;
import com.kafka.repository.UserTeamRepository;
import com.kafka.service.IUserTeamService;
import com.kafka.utils.PagerUtil;

@Service
public class UserTeamServiceImpl implements IUserTeamService{

	@Autowired
	private UserTeamRepository userTeamRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserTeamMapper userTeamMapper;
	
	private UserTeam create(UserTeamRequestDTO userTeamRequestDTO) {
		return userTeamMapper.userTeamRequestDTOToEntity(userTeamRequestDTO);
	}
	
	private UserTeam getUserTeamById(Long id) {
		return userTeamRepository.findById(id).orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString())));
	}
	
	private User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString())));
	}
	
	private Team getTeamById(Long id) {
		return teamRepository.findById(id).orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString())));
	}
	
	private Role getRoleById(Long id) {
		return roleRepository.findById(id).orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString())));
	}
	
	@Override
	public UserTeamResponseDTO save(UserTeamRequestDTO userTeamRequestDTO) {
		UserTeam userTeam = create(userTeamRequestDTO);
		userTeam.setUser(getUserById(userTeamRequestDTO.getUserId()));
		userTeam.setTeam(getTeamById(userTeamRequestDTO.getTeamId()));
		userTeam.setRole(getRoleById(userTeamRequestDTO.getRoleId()));
		UserTeam savedUserTeam = userTeamRepository.save(userTeam);
		return userTeamMapper.entityToUserTeamResponseDTO(savedUserTeam);
	}

	@Override
	public UserTeamResponseDTO update(Long id, UserTeamRequestDTO userTeamRequestDTO) {
		UserTeam userTeamToUpdate = getUserTeamById(id);
		userTeamMapper.userTeamRequestDTOToEntity(userTeamRequestDTO, userTeamToUpdate);
		userTeamToUpdate.setUser(getUserById(userTeamRequestDTO.getUserId()));
		userTeamToUpdate.setTeam(getTeamById(userTeamRequestDTO.getTeamId()));
		userTeamToUpdate.setRole(getRoleById(userTeamRequestDTO.getRoleId()));
		UserTeam savedUserTeam = userTeamRepository.save(userTeamToUpdate);
		return userTeamMapper.entityToUserTeamResponseDTO(savedUserTeam);
	}

	@Override
	public Long delete(Long id) {
		userTeamRepository.delete(getUserTeamById(id));
		return id;
	}

	@Override
	public UserTeamResponseDTO findUserTeamById(Long id) {
		return userTeamMapper.entityToUserTeamResponseDTO(getUserTeamById(id));
	}

	@Override
	public List<UserTeamResponseDTO> getAllUsersTeams() {
		return userTeamMapper.entitiesToUserTeamResponseDTOs(userTeamRepository.findAll());
	}

	@Override
	public RestPageableResponseDTO<UserTeamResponseDTO> getPageableResponse(
			RestPageableRequestDTO restPageableRequestDTO) {
		Page<UserTeam> page = userTeamRepository.findAllPageable(PagerUtil.toPageable(restPageableRequestDTO));
		List<UserTeamResponseDTO> userTeamResponseDTOs = userTeamMapper.entitiesToUserTeamResponseDTOs(page.getContent());
		return PagerUtil.toPageableResponse(page, userTeamResponseDTOs);
	}

}
