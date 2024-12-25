package com.kafka.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequestDTO {

	  @NotEmpty(message = "username cannot be empty")
	  @Size(min = 2, max = 50, message = " username must be between 2 and 50 characters")
	  private String username;

	  @NotEmpty(message = "Password cannot be empty")
	  private String password;
}
