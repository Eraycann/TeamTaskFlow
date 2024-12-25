package com.kafka.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.RoleRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.RoleResponseDTO;
import com.kafka.exception.BaseException;
import com.kafka.exception.ErrorMessage;
import com.kafka.exception.MessageType;
import com.kafka.mapper.RoleMapper;
import com.kafka.model.Role;
import com.kafka.repository.RoleRepository;
import com.kafka.service.IRoleService;
import com.kafka.utils.PagerUtil;

@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleMapper roleMapper;
	
	
	private Role createRole(RoleRequestDTO roleRequestDTO) {
		return roleMapper.RoleRequestDTOToEntity(roleRequestDTO);
	}
	
	private Role getRoleById(Long id) {
		return roleRepository.findById(id).orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString())));
	}
	
	@Override
	public RoleResponseDTO saveRole(RoleRequestDTO roleRequestDTO) {
		Role savedRole = roleRepository.save(createRole(roleRequestDTO));
		return roleMapper.entityToRoleResponseDTO(savedRole);
	}

	@Override
	public RoleResponseDTO updateRole(Long roleId, RoleRequestDTO roleRequestDTO) {
		Role roleToUpdate = getRoleById(roleId);
		roleMapper.RoleRequestDTOToEntity(roleRequestDTO, roleToUpdate);
		Role updatedRole = roleRepository.save(roleToUpdate);
		return roleMapper.entityToRoleResponseDTO(updatedRole);
	}

	@Override
	public Long deleteRole(Long roleId) {
		roleRepository.delete(getRoleById(roleId));
		return roleId;
	}

	@Override
	public RoleResponseDTO findRoleById(Long roleId) {
		return roleMapper.entityToRoleResponseDTO(getRoleById(roleId));
	}

	@Override
	public List<RoleResponseDTO> getAllRoles() {
		return roleMapper.entitiesToRoleResponseDTOs(roleRepository.findAll());
	}

	@Override
	public RestPageableResponseDTO<RoleResponseDTO> getPageableResponse(RestPageableRequestDTO restPageableRequestDTO) {
		Page<Role> page = roleRepository.findAllPageable(PagerUtil.toPageable(restPageableRequestDTO));
		List<RoleResponseDTO> roleResponseDTOs = roleMapper.entitiesToRoleResponseDTOs(page.getContent());
		return PagerUtil.toPageableResponse(page, roleResponseDTOs);
	}
}
