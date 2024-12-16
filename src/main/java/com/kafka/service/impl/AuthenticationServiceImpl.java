package com.kafka.service.impl;

import org.springframework.stereotype.Service;

import com.kafka.dto.request.AuthRequestDTO;
import com.kafka.dto.request.RefreshTokenRequestDTO;
import com.kafka.dto.response.AuthResponseDTO;
import com.kafka.dto.response.UserResponseDTO;
import com.kafka.model.User;
import com.kafka.service.IAuthenticationService;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService{

	private User createUser(AuthRequestDTO input) {
		return null;
	}
	
	@Override
	public UserResponseDTO register(AuthRequestDTO input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthResponseDTO authenticate(AuthRequestDTO input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthResponseDTO refreshToken(RefreshTokenRequestDTO input) {
		// TODO Auto-generated method stub
		return null;
	}

}
