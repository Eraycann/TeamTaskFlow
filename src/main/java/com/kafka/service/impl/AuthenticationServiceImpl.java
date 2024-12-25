package com.kafka.service.impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kafka.dto.request.AuthRequestDTO;
import com.kafka.dto.request.RefreshTokenRequestDTO;
import com.kafka.dto.request.UserRequestDTO;
import com.kafka.dto.response.AuthResponseDTO;
import com.kafka.dto.response.UserResponseDTO;
import com.kafka.exception.BaseException;
import com.kafka.exception.ErrorMessage;
import com.kafka.exception.MessageType;
import com.kafka.jwt.JWTService;
import com.kafka.mapper.UserMapper;
import com.kafka.model.RefreshToken;
import com.kafka.model.User;
import com.kafka.repository.RefreshTokenRepository;
import com.kafka.repository.UserRepository;
import com.kafka.service.IAuthenticationService;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	
	
	
	private User createUser(UserRequestDTO input) {
		User user = userMapper.userRequestDTOToEntity(input);
		user.setPassword(passwordEncoder.encode(input.getPassword()));
		return user;
	}
	
	@Override
	public UserResponseDTO register(UserRequestDTO input) {
		return userMapper.entityToUserResponseDTO(userRepository.save(createUser(input)));
	}
	
	

	
	private RefreshToken createRefreshToken(User user) {
		RefreshToken refreshToken = new RefreshToken();
		refreshToken.setCreatedAt(LocalDateTime.now());
		refreshToken.setExpiredDate(LocalDateTime.now().plusHours(4));
		refreshToken.setRefreshToken(UUID.randomUUID().toString());
		refreshToken.setUser(user);
		return refreshToken;
	}
	
	@Override
	public AuthResponseDTO authenticate(AuthRequestDTO input) {
		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(input.getUsername(), input.getPassword());
			authenticationProvider.authenticate(authenticationToken);
			
			Optional<User> optUser = userRepository.findByUsername(input.getUsername());
			String accessToken = jwtService.generateToken(optUser.get());
			RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(optUser.get()));
			
			return new AuthResponseDTO(accessToken, savedRefreshToken.getRefreshToken());
		} catch (Exception e) {
			throw new BaseException(new ErrorMessage(MessageType.USERNAME_OR_PASSWORD_INVALID, e.getMessage()));
		}
	}

	
	public boolean isValidRefreshToken(LocalDateTime expiredDate) {
		return LocalDateTime.now().isBefore(expiredDate);
	}
	
	@Override
	public AuthResponseDTO refreshToken(RefreshTokenRequestDTO input) {
		Optional<RefreshToken> optRefreshToken = refreshTokenRepository.findByRefreshToken(input.getRefreshToken());
		if(optRefreshToken.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_NOT_FOUND, input.getRefreshToken()));
		}
		
		if(!isValidRefreshToken(optRefreshToken.get().getExpiredDate())) {
			throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_IS_EXPIRED, input.getRefreshToken()));
		}
		
		User user = optRefreshToken.get().getUser();
		String accessToken = jwtService.generateToken(user);
		RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(user));
		
		return new AuthResponseDTO(accessToken, savedRefreshToken.getRefreshToken());
	}
}
