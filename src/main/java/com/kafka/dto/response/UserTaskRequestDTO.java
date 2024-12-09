package com.kafka.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTaskRequestDTO extends BaseResponseDTO{

	private UserResponseDTO user;
	
	private TaskResponseDTO task;
	
	private RoleResponseDTO role;
}
