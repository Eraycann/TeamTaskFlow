package com.kafka.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRequestDTO {

    @NotEmpty(message = "Role name cannot be empty")
    @Size(min = 3, max = 50, message = "Role name must be between 3 and 50 characters")
    private String roleName;

    @Size(max = 250, message = "Description cannot exceed 250 characters")
	private String description;
}
