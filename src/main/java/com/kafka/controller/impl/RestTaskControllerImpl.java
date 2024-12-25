package com.kafka.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.controller.IRestTaskController;
import com.kafka.controller.RestBaseController;
import com.kafka.controller.RootEntity;
import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.TaskRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.TaskResponseDTO;
import com.kafka.service.ITaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/task")
public class RestTaskControllerImpl extends RestBaseController implements IRestTaskController{

	@Autowired
	private ITaskService taskService; 
	
	@PostMapping("/save")
	@Override
	public RootEntity<TaskResponseDTO> save(@RequestBody @Valid TaskRequestDTO taskRequestDTO) {
		return ok(taskService.save(taskRequestDTO));
	}

	@PutMapping("/update/{id}")
	@Override
	public RootEntity<TaskResponseDTO> update(@PathVariable(name="id") Long id, @RequestBody @Valid TaskRequestDTO taskRequestDTO) {
		return ok(taskService.update(id, taskRequestDTO));
	}

	@DeleteMapping("/delete/{id}")
	@Override
	public RootEntity<Long> delete(@PathVariable(name="id") Long id) {
		return ok(taskService.delete(id));
	}

	@PostMapping("/findTaskById/{id}")
	@Override
	public RootEntity<TaskResponseDTO> findTaskById(@PathVariable(name="id") Long id) {
		return ok(taskService.findTaskById(id));
	}

	@PostMapping("/getAllTasks")
	@Override
	public RootEntity<List<TaskResponseDTO>> getAllTasks() {
		return ok(taskService.getAllTasks());
	}

	@PostMapping("/paginated-tasks")
	@Override
	public RootEntity<RestPageableResponseDTO<TaskResponseDTO>> getPageableResponse(
			RestPageableRequestDTO restPageableRequestDTO) {
		return ok(taskService.getPageableResponse(restPageableRequestDTO));
	}

}
