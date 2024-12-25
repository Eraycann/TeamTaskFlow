package com.kafka.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.kafka.dto.request.UserTeamRequestDTO;
import com.kafka.dto.response.UserTeamResponseDTO;
import com.kafka.model.UserTeam;

@Mapper(componentModel = "spring", uses = {UserMapper.class, TeamMapper.class, RoleMapper.class})
public interface UserTeamMapper {

	UserTeamResponseDTO entityToUserTeamResponseDTO(UserTeam userTeam);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "team", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
	UserTeam userTeamRequestDTOToEntity(UserTeamRequestDTO userTeamRequestDTO);
	
	List<UserTeamResponseDTO> entitiesToUserTeamResponseDTOs(List<UserTeam> userTeams);
	
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "team", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
	void userTeamRequestDTOToEntity(UserTeamRequestDTO userTeamRequestDTO, @MappingTarget UserTeam userTeam);
}
