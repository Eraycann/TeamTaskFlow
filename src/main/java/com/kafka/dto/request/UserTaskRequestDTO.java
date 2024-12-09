package com.kafka.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTaskRequestDTO {

    @NotNull(message = "User ID cannot be null")
	private Long userId;
	
    @NotNull(message = "Task ID cannot be null")
	private Long taskId;
	
    @NotNull(message = "Role ID cannot be null")
	private Long roleId;
}
