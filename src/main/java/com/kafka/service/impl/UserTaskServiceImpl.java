package com.kafka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.UserTaskRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.UserTaskResponseDTO;
import com.kafka.exception.BaseException;
import com.kafka.exception.ErrorMessage;
import com.kafka.exception.MessageType;
import com.kafka.mapper.UserTaskMapper;
import com.kafka.model.Role;
import com.kafka.model.Task;
import com.kafka.model.User;
import com.kafka.model.UserTask;
import com.kafka.repository.RoleRepository;
import com.kafka.repository.TaskRepository;
import com.kafka.repository.UserRepository;
import com.kafka.repository.UserTaskRepository;
import com.kafka.service.IUserTaskService;
import com.kafka.utils.PagerUtil;

@Service
public class UserTaskServiceImpl implements IUserTaskService{

	@Autowired
	private UserTaskRepository userTaskRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserTaskMapper userTaskMapper;

	
	private UserTask create(UserTaskRequestDTO userTaskRequestDTO) {
		return userTaskMapper.userTaskRequestDTOToEntity(userTaskRequestDTO);
	}
	
	private UserTask getUserTaskById(Long id) {
		return userTaskRepository.findById(id).orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString())));
	}
	
	private User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString())));
	}
	
	private Task getTaskById(Long id) {
		return taskRepository.findById(id).orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString())));
	}
	
	private Role getRoleById(Long id) {
		return roleRepository.findById(id).orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString())));
	}


	@Override
	public UserTaskResponseDTO save(UserTaskRequestDTO userTaskRequestDTO) {
		UserTask userTask = create(userTaskRequestDTO);
		userTask.setUser(getUserById(userTaskRequestDTO.getUserId()));
		userTask.setTask(getTaskById(userTaskRequestDTO.getTaskId()));
		userTask.setRole(getRoleById(userTaskRequestDTO.getRoleId()));
		UserTask savedUserTask = userTaskRepository.save(userTask);
		return userTaskMapper.entityToUserTaskResponseDTO(savedUserTask);
	}


	@Override
	public UserTaskResponseDTO update(Long id, UserTaskRequestDTO userTaskRequestDTO) {
		UserTask userTaskToUpdate = getUserTaskById(id);
		userTaskMapper.userTaskRequestDTOToEntity(userTaskRequestDTO, userTaskToUpdate);
		userTaskToUpdate.setUser(getUserById(userTaskRequestDTO.getUserId()));
		userTaskToUpdate.setTask(getTaskById(userTaskRequestDTO.getTaskId()));
		userTaskToUpdate.setRole(getRoleById(userTaskRequestDTO.getRoleId()));
		UserTask savedUserTask = userTaskRepository.save(userTaskToUpdate);
		return userTaskMapper.entityToUserTaskResponseDTO(savedUserTask);
	}


	@Override
	public Long delete(Long id) {
		userTaskRepository.delete(getUserTaskById(id));
		return id;
	}


	@Override
	public UserTaskResponseDTO findUserTaskById(Long id) {
		return userTaskMapper.entityToUserTaskResponseDTO(getUserTaskById(id));
	}


	@Override
	public List<UserTaskResponseDTO> getAllUsersTasks() {
		return userTaskMapper.entitiesToUserTaskResponseDTOs(userTaskRepository.findAll());
	}

	@Override
	public RestPageableResponseDTO<UserTaskResponseDTO> getPageableResponse(
			RestPageableRequestDTO restPageableRequestDTO) {
		Page<UserTask> page = userTaskRepository.findAllPageable(PagerUtil.toPageable(restPageableRequestDTO));
		List<UserTaskResponseDTO> userTaskResponseDTOs = userTaskMapper.entitiesToUserTaskResponseDTOs(page.getContent());
		return PagerUtil.toPageableResponse(page, userTaskResponseDTOs);
	}
}
