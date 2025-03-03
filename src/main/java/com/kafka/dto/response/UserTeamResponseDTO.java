package com.kafka.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTeamResponseDTO {
	
	private Long id;

	private UserResponseDTO user;
	
	private TeamResponseDTO team;
	
	private RoleResponseDTO role;
	
	private Boolean isActive;
}
