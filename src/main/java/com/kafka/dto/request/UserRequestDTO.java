package com.kafka.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO extends BaseRequestDTO{

	  @NotEmpty(message = "First name cannot be empty")
	  @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
	  private String firstName;

	  @NotEmpty(message = "Last name cannot be empty")
	  @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
	  private String lastName;

	  @Email(message = "Email must be in a valid format")	// @Email varken, @NotEmpty'e gerek yok.
	  @Size(max = 50, message = "Email cannot exceed 50 characters")
	  private String email;

	  @NotEmpty(message = "Password cannot be empty")
	  private String password;

	  private LocalDateTime updatedAt;
}
