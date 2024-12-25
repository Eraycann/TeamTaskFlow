package com.kafka.service;

import java.util.List;

import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.RoleRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.RoleResponseDTO;
import com.kafka.dto.response.UserResponseDTO;

public interface IRoleService {

	public RoleResponseDTO saveRole(RoleRequestDTO roleRequestDTO);
	
	public RoleResponseDTO updateRole(Long roleId, RoleRequestDTO roleRequestDTO);
	
	public Long deleteRole(Long roleId);
	
	public RoleResponseDTO findRoleById(Long roleId);
	
	public List<RoleResponseDTO> getAllRoles();

	public RestPageableResponseDTO<RoleResponseDTO> getPageableResponse(RestPageableRequestDTO restPageableRequestDTO);
}
