package com.kafka.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

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
    
    List<TeamResponseDTO> entititesTeamResponseDTOs(List<Team> teams);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "owner", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
	void TeamRequestDTOToEntity(TeamRequestDTO teamRequestDTO, @MappingTarget Team team);
}
