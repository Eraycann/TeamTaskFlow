package com.kafka.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTeamResponseDTO {

	private UserResponseDTO user;
	
	private TeamResponseDTO team;
	
	private RoleResponseDTO role;
	
	private Boolean isActive;
}
