package com.kafka.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.kafka.dto.request.RoleRequestDTO;
import com.kafka.dto.response.RoleResponseDTO;
import com.kafka.model.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {

	RoleResponseDTO entityToRoleResponseDTO(Role role);
	
    @Mapping(target = "id", ignore = true)
	Role RoleRequestDTOToEntity(RoleRequestDTO roleRequestDTO);
}
