package com.kafka.service;

import com.kafka.dto.request.AuthRequestDTO;
import com.kafka.dto.request.RefreshTokenRequestDTO;
import com.kafka.dto.response.AuthResponseDTO;
import com.kafka.dto.response.UserResponseDTO;

public interface IAuthenticationService {

	public UserResponseDTO register(AuthRequestDTO input);
	
	public AuthResponseDTO authenticate(AuthRequestDTO input);
	
	public AuthResponseDTO refreshToken(RefreshTokenRequestDTO input);
}
