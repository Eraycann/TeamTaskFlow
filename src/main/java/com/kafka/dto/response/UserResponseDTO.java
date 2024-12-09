package com.kafka.dto.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO extends BaseResponseDTO{

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private LocalDateTime updatedAt;
}
