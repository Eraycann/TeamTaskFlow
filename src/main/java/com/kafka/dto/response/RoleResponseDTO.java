package com.kafka.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleResponseDTO{

	private Long id;
	
	private String roleName;

	private String description;
}
