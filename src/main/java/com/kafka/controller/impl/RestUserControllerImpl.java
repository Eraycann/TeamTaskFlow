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

import com.kafka.controller.IRestUserController;
import com.kafka.controller.RestBaseController;
import com.kafka.controller.RootEntity;
import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.UserRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.UserResponseDTO;
import com.kafka.service.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/user")
public class RestUserControllerImpl extends RestBaseController implements IRestUserController{

	@Autowired
	private IUserService userService;
	
	@PutMapping("/update/{id}")
	@Override
	public RootEntity<UserResponseDTO> updateUser(@PathVariable(name="id") Long userId, @Valid @RequestBody UserRequestDTO userRequestDTO) {
		return ok(userService.updateUser(userId, userRequestDTO));
	}

	@DeleteMapping("/delete/{id}")
	@Override
	public RootEntity<Long> deleteUser(@PathVariable(name="id") Long userId) {
		return ok(userService.deleteUser(userId));
	}

	@PostMapping("/findUserById/{id}")
	@Override
	public RootEntity<UserResponseDTO> findUserById(@PathVariable(name="id") Long userId) {
		return ok(userService.findUserById(userId));
	}

	@PostMapping("/getAllUsers")
	@Override
	public RootEntity<List<UserResponseDTO>> getAllUsers() {
		return ok(userService.getAllUsers());
	}

	@PostMapping("/paginated-users")
	@Override
	public RootEntity<RestPageableResponseDTO<UserResponseDTO>> getPageableResponse(
			RestPageableRequestDTO restPageableRequestDTO) {
		return ok(userService.getPageableResponse(restPageableRequestDTO));
	}
}
