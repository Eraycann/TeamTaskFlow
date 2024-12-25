package com.kafka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.TaskRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.TaskResponseDTO;
import com.kafka.exception.BaseException;
import com.kafka.exception.ErrorMessage;
import com.kafka.exception.MessageType;
import com.kafka.mapper.TaskMapper;
import com.kafka.model.Task;
import com.kafka.model.User;
import com.kafka.repository.TaskRepository;
import com.kafka.repository.UserRepository;
import com.kafka.service.ITaskService;
import com.kafka.utils.PagerUtil;

@Service
public class TaskServiceImpl implements ITaskService{

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private TaskMapper taskMapper;
	
	private Task create(TaskRequestDTO taskRequestDTO) {
		return taskMapper.TaskRequestDTOToEntity(taskRequestDTO);
	}
	
	private Task getTaskById(Long id) {
		return taskRepository.findById(id).orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString())));
	}
	
	private User getUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString())));
		return user;
	}
	
	@Override
	public TaskResponseDTO save(TaskRequestDTO taskRequestDTO) {
		Task task = create(taskRequestDTO);
		task.setAssignedBy(getUserById(taskRequestDTO.getAssignedBy()));
		// task.setUpdatedBy(getUserById(taskRequestDTO.getUpdatedBy()));
		Task savedTask = taskRepository.save(task);
		return taskMapper.entityToTaskResponseDTO(savedTask);
	}

	@Override
	public TaskResponseDTO update(Long id, TaskRequestDTO taskRequestDTO) {
		Task taskToUpdate = getTaskById(id);
		taskMapper.TaskRequestDTOToEntity(taskRequestDTO, taskToUpdate);
		taskToUpdate.setAssignedBy(getUserById(taskRequestDTO.getAssignedBy()));
		taskToUpdate.setUpdatedBy(getUserById(taskRequestDTO.getUpdatedBy()));
		Task savedTask = taskRepository.save(taskToUpdate);
		return taskMapper.entityToTaskResponseDTO(savedTask);
	}

	@Override
	public Long delete(Long id) {
		taskRepository.delete(getTaskById(id));
		return id;
	}

	@Override
	public TaskResponseDTO findTaskById(Long id) {
		return taskMapper.entityToTaskResponseDTO(getTaskById(id));
	}

	@Override
	public List<TaskResponseDTO> getAllTasks() {
		return taskMapper.entitiesToTaskResponseDTOs(taskRepository.findAll());
	}

	@Override
	public RestPageableResponseDTO<TaskResponseDTO> getPageableResponse(RestPageableRequestDTO restPageableRequestDTO) {
		Page<Task> page = taskRepository.findAllPageable(PagerUtil.toPageable(restPageableRequestDTO));
		List<TaskResponseDTO> taskResponseDTOs = taskMapper.entitiesToTaskResponseDTOs(page.getContent());
		return PagerUtil.toPageableResponse(page, taskResponseDTOs);
	}

}
