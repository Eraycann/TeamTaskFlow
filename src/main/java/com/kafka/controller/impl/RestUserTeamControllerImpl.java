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

import com.kafka.controller.IRestUserTeamController;
import com.kafka.controller.RestBaseController;
import com.kafka.controller.RootEntity;
import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.UserTeamRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.UserTeamResponseDTO;
import com.kafka.service.IUserTeamService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/user-team")
public class RestUserTeamControllerImpl extends RestBaseController implements IRestUserTeamController{

	@Autowired
	private IUserTeamService userTeamService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<UserTeamResponseDTO> save(@RequestBody @Valid UserTeamRequestDTO userTeamRequestDTO) {
		return ok(userTeamService.save(userTeamRequestDTO));
	}

	@PutMapping("/update/{id}")
	@Override
	public RootEntity<UserTeamResponseDTO> update(@PathVariable(name="id") Long id, @RequestBody @Valid UserTeamRequestDTO userTeamRequestDTO) {
		return ok(userTeamService.update(id, userTeamRequestDTO));
	}

	@DeleteMapping("/delete/{id}")
	@Override
	public RootEntity<Long> delete(@PathVariable(name="id") Long id) {
		return ok(userTeamService.delete(id));
	}

	@PostMapping("/findUserTeamById/{id}")
	@Override
	public RootEntity<UserTeamResponseDTO> findUserTeamById(@PathVariable(name="id") Long id) {
		return ok(userTeamService.findUserTeamById(id));
	}

	@PostMapping("/getAllUsersTeams")
	@Override
	public RootEntity<List<UserTeamResponseDTO>> getAllUsersTeams() {
		return ok(userTeamService.getAllUsersTeams());
	}

	@PostMapping("/paginated-usersTeams")
	@Override
	public RootEntity<RestPageableResponseDTO<UserTeamResponseDTO>> getPageableResponse(
			RestPageableRequestDTO restPageableRequestDTO) {
		return ok(userTeamService.getPageableResponse(restPageableRequestDTO));
	}
}
