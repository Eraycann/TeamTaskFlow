package com.kafka.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTeamRequestDTO {

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotNull(message = "Team ID cannot be null")
    private Long teamId;

    @NotNull(message = "Role ID cannot be null")
    private Long roleId;
	
	private Boolean isActive = true;
}
