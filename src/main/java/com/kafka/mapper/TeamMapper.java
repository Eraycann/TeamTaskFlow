package com.kafka.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.kafka.dto.request.TeamRequestDTO;
import com.kafka.dto.response.TeamResponseDTO;
import com.kafka.model.Team;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface TeamMapper {

	TeamResponseDTO entityToTeamResponseDTO(Team team);
	
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "owner", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
	Team TeamRequestDTOToEntity(TeamRequestDTO teamRequestDTO);
}
