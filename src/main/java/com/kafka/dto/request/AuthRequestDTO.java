package com.kafka.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequestDTO {

	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
}
