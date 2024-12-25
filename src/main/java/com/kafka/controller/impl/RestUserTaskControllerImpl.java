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

import com.kafka.controller.IRestUserTaskController;
import com.kafka.controller.RestBaseController;
import com.kafka.controller.RootEntity;
import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.UserTaskRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.UserTaskResponseDTO;
import com.kafka.service.IUserTaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/user-task")
public class RestUserTaskControllerImpl extends RestBaseController implements IRestUserTaskController{

	@Autowired
	private IUserTaskService userTaskService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<UserTaskResponseDTO> save(@RequestBody @Valid UserTaskRequestDTO userTaskRequestDTO) {
		return ok(userTaskService.save(userTaskRequestDTO));
	}

	@PutMapping("/update/{id}")
	@Override
	public RootEntity<UserTaskResponseDTO> update(@PathVariable(name="id") Long id, @RequestBody @Valid UserTaskRequestDTO userTaskRequestDTO) {
		return ok(userTaskService.update(id, userTaskRequestDTO));
	}

	@DeleteMapping("/delete/{id}")
	@Override
	public RootEntity<Long> delete(@PathVariable(name="id") Long id) {
		return ok(userTaskService.delete(id));
	}

	@PostMapping("/findUserTaskById/{id}")
	@Override
	public RootEntity<UserTaskResponseDTO> findUserTaskById(@PathVariable(name="id") Long id) {
		return ok(userTaskService.findUserTaskById(id));
	}

	@PostMapping("/getAllUsersTasks")
	@Override
	public RootEntity<List<UserTaskResponseDTO>> getAllUsersTasks() {
		return ok(userTaskService.getAllUsersTasks());
	}

	@PostMapping("/paginated-usersTasks")
	@Override
	public RootEntity<RestPageableResponseDTO<UserTaskResponseDTO>> getPageableResponse(
			RestPageableRequestDTO restPageableRequestDTO) {
		return ok(userTaskService.getPageableResponse(restPageableRequestDTO));
	}
}
