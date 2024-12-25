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

import com.kafka.controller.IRestTeamController;
import com.kafka.controller.RestBaseController;
import com.kafka.controller.RootEntity;
import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.TeamRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.TeamResponseDTO;
import com.kafka.service.ITeamService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/team")
public class RestTeamControllerImpl extends RestBaseController implements IRestTeamController{

	@Autowired
	private ITeamService teamService;

	@PostMapping("/save")
	@Override
	public RootEntity<TeamResponseDTO> save(@RequestBody @Valid TeamRequestDTO teamRequestDTO) {
		return ok(teamService.save(teamRequestDTO));
	}

	@PutMapping("/update/{id}")
	@Override
	public RootEntity<TeamResponseDTO> update(@PathVariable(name="id") Long id, @RequestBody @Valid TeamRequestDTO teamRequestDTO) {
		return ok(teamService.update(id, teamRequestDTO));
	}

	@DeleteMapping("/delete/{id}")
	@Override
	public RootEntity<Long> delete(@PathVariable(name="id") Long id) {
		return ok(teamService.delete(id));
	}

	@PostMapping("/findTeamById/{id}")
	@Override
	public RootEntity<TeamResponseDTO> findTeamById(@PathVariable(name="id") Long id) {
		return ok(teamService.findTeamById(id));
	}

	@PostMapping("/getAllTeams")
	@Override
	public RootEntity<List<TeamResponseDTO>> getAllTeams() {
		return ok(teamService.getAllTeams());
	}

	@PostMapping("/paginated-teams")
	@Override
	public RootEntity<RestPageableResponseDTO<TeamResponseDTO>> getPageableResponse(
			RestPageableRequestDTO restPageableRequestDTO) {
		return ok(teamService.getPageableResponse(restPageableRequestDTO));
	}
}
