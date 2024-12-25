package com.kafka.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.UserRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.UserResponseDTO;
import com.kafka.exception.BaseException;
import com.kafka.exception.ErrorMessage;
import com.kafka.exception.MessageType;
import com.kafka.mapper.UserMapper;
import com.kafka.model.User;
import com.kafka.repository.UserRepository;
import com.kafka.service.IUserService;
import com.kafka.utils.PagerUtil;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRepository userRepository;
	
//	private User createUser(UserRequestDTO userRequestDTO) {
//		return userMapper.userRequestDTOToEntity(userRequestDTO);
//	}
	
	private User getUserById(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, userId.toString())));
	}
	
	@Override
	public UserResponseDTO updateUser(Long userId, UserRequestDTO userRequestDTO) {
		User userToUpdate = getUserById(userId);
		userMapper.userRequestDTOToEntity(userRequestDTO, userToUpdate);
		User updatedUser = userRepository.save(userToUpdate);
		return userMapper.entityToUserResponseDTO(updatedUser);
	}

	@Override
	public Long deleteUser(Long userId) {
		userRepository.delete(getUserById(userId));
		return userId;
	}

	@Override
	public UserResponseDTO findUserById(Long userId) {
		return userMapper.entityToUserResponseDTO(getUserById(userId));
	}

	@Override
	public List<UserResponseDTO> getAllUsers() {
		return userMapper.entitiesToUserResponseDTOs(userRepository.findAll());
	}

	@Override
	public RestPageableResponseDTO<UserResponseDTO> getPageableResponse(RestPageableRequestDTO restPageableRequestDTO) {
		Page<User> page = userRepository.findAllPageable(PagerUtil.toPageable(restPageableRequestDTO));
		List<UserResponseDTO> userResponseDTOs = userMapper.entitiesToUserResponseDTOs(page.getContent());
		return PagerUtil.toPageableResponse(page, userResponseDTOs);
	}

}
