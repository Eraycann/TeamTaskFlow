package com.kafka.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseDTO {

	private String accessToken;
	
	private String refreshToken;
}
