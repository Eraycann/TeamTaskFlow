package com.kafka.mapper;

import org.mapstruct.Mapper;

import com.kafka.dto.response.UserTeamResponseDTO;
import com.kafka.model.UserTeam;

@Mapper(componentModel = "spring", uses = {UserMapper.class, TeamMapper.class, RoleMapper.class})
public interface UserTeamMapper {

	UserTeamResponseDTO entityToUserTeamResponseDTO(UserTeam userTeam);

	
}
