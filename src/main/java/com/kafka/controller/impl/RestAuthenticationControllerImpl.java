package com.kafka.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.controller.IRestAuthenticationController;
import com.kafka.controller.RestBaseController;
import com.kafka.controller.RootEntity;
import com.kafka.dto.request.AuthRequestDTO;
import com.kafka.dto.request.RefreshTokenRequestDTO;
import com.kafka.dto.request.UserRequestDTO;
import com.kafka.dto.response.AuthResponseDTO;
import com.kafka.dto.response.UserResponseDTO;
import com.kafka.service.IAuthenticationService;

import jakarta.validation.Valid;

@RestController
public class RestAuthenticationControllerImpl extends RestBaseController implements IRestAuthenticationController{

	@Autowired 
	private IAuthenticationService authenticationService;

	@PostMapping("/register")
	@Override
	public RootEntity<UserResponseDTO> register(@Valid @RequestBody UserRequestDTO input) {
		return ok(authenticationService.register(input));
	}

	@PostMapping("/authenticate")
	@Override
	public RootEntity<AuthResponseDTO> authenticate(@Valid @RequestBody AuthRequestDTO input) {
		return ok(authenticationService.authenticate(input));
	}

	@PostMapping("/refreshToken")
	@Override
	public RootEntity<AuthResponseDTO> refreshToken(@Valid @RequestBody RefreshTokenRequestDTO input) {
		return ok(authenticationService.refreshToken(input));
	}
}
