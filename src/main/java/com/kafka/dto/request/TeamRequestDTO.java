package com.kafka.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamRequestDTO {

    @NotEmpty(message = "Team name cannot be empty")
    @Size(min = 3, max = 50, message = "Team name must be between 3 and 50 characters")
    private String teamName;

    @NotNull(message = "Owner ID cannot be null")
    private Long owner; // userId
}
