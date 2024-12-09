package com.kafka.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRequestDTO {

    @NotNull(message = "ID cannot be null")
	private Long id;
}
