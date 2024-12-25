package com.kafka.controller;

import com.kafka.dto.request.AuthRequestDTO;
import com.kafka.dto.request.RefreshTokenRequestDTO;
import com.kafka.dto.request.UserRequestDTO;
import com.kafka.dto.response.AuthResponseDTO;
import com.kafka.dto.response.UserResponseDTO;

import jakarta.validation.Valid;

public interface IRestAuthenticationController {

	public RootEntity<UserResponseDTO> register( UserRequestDTO input);
	
	public RootEntity<AuthResponseDTO> authenticate(AuthRequestDTO input);
	
	public RootEntity<AuthResponseDTO> refreshToken(RefreshTokenRequestDTO input);
}
