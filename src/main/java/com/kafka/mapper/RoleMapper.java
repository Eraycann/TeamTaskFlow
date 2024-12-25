package com.kafka.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.kafka.dto.request.RoleRequestDTO;
import com.kafka.dto.response.RoleResponseDTO;
import com.kafka.model.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {

	RoleResponseDTO entityToRoleResponseDTO(Role role);
	
	// create
    @Mapping(target = "id", ignore = true)
	Role RoleRequestDTOToEntity(RoleRequestDTO roleRequestDTO);
    
    List<RoleResponseDTO> entitiesToRoleResponseDTOs(List<Role> roles);
    
    // update
    @Mapping(target = "id", ignore = true)
	void RoleRequestDTOToEntity(RoleRequestDTO roleRequestDTO, @MappingTarget Role role);
}
