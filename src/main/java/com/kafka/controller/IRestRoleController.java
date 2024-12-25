package com.kafka.controller;

import java.util.List;

import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.RoleRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.RoleResponseDTO;
import com.kafka.dto.response.UserResponseDTO;

public interface IRestRoleController {

	public RootEntity<RoleResponseDTO> saveRole(RoleRequestDTO roleRequestDTO);
	
	public RootEntity<RoleResponseDTO> updateRole(Long roleId ,RoleRequestDTO roleRequestDTO);
	
	public RootEntity<Long> deleteRole(Long roleId);
	
	public RootEntity<RoleResponseDTO> findRoleById(Long roleId);
	
	public RootEntity<List<RoleResponseDTO>> getAllRoles();
	
	public RootEntity<RestPageableResponseDTO<RoleResponseDTO>> getPageableResponse(RestPageableRequestDTO restPageableRequestDTO);

}
