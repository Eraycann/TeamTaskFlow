package com.kafka.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.kafka.dto.request.UserRequestDTO;
import com.kafka.dto.response.UserResponseDTO;
import com.kafka.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserResponseDTO entityToUserResponseDTO(User user);
	
    @Mapping(target = "id", ignore = true)
	@Mapping(target = "createdAt", ignore = true)
    User UserRequestDTOToEntity(UserRequestDTO userRequestDTO);
}
