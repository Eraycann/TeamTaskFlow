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

import com.kafka.controller.IRestRoleController;
import com.kafka.controller.RestBaseController;
import com.kafka.controller.RootEntity;
import com.kafka.dto.request.RestPageableRequestDTO;
import com.kafka.dto.request.RoleRequestDTO;
import com.kafka.dto.response.RestPageableResponseDTO;
import com.kafka.dto.response.RoleResponseDTO;
import com.kafka.service.IRoleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/role")
public class RestRoleControllerImpl extends RestBaseController implements IRestRoleController{

	@Autowired
	private IRoleService roleService;

	@PostMapping("/create")
	@Override
	public RootEntity<RoleResponseDTO> saveRole(@RequestBody @Valid RoleRequestDTO roleRequestDTO) {
		return ok(roleService.saveRole(roleRequestDTO));
	}

	@PutMapping("/update/{id}")
	@Override
	public RootEntity<RoleResponseDTO> updateRole(@PathVariable(name="id") Long roleId, @RequestBody @Valid RoleRequestDTO roleRequestDTO) {
		return ok(roleService.updateRole(roleId, roleRequestDTO));
	}

	@DeleteMapping("/delete/{id}")
	@Override
	public RootEntity<Long> deleteRole(@PathVariable(name="id") Long roleId) {
		return ok(roleService.deleteRole(roleId));
	}

	@PostMapping("/findRoleById/{id}")
	@Override
	public RootEntity<RoleResponseDTO> findRoleById(@PathVariable(name="id") Long roleId) {
		return ok(roleService.findRoleById(roleId));
	}

	@PostMapping("/getAllRoles")
	@Override
	public RootEntity<List<RoleResponseDTO>> getAllRoles() {
		return ok(roleService.getAllRoles());
	}

	@PostMapping("/paginated-roles")
	@Override
	public RootEntity<RestPageableResponseDTO<RoleResponseDTO>> getPageableResponse(
			RestPageableRequestDTO restPageableRequestDTO) {
		return ok(roleService.getPageableResponse(restPageableRequestDTO));
	}
}
