package com.kafka.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamResponseDTO extends BaseResponseDTO{

	private String teamName;

	private UserResponseDTO owner;
}
