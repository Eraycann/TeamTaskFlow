package com.kafka.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.kafka.dto.request.UserRequestDTO;
import com.kafka.dto.response.UserResponseDTO;
import com.kafka.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserResponseDTO entityToUserResponseDTO(User user);
	
	// create_user
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "password", ignore = true)
    User userRequestDTOToEntity(UserRequestDTO userRequestDTO);
    
    List<UserResponseDTO> entitiesToUserResponseDTOs(List<User> users);
    
    // update_user
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "password", ignore = true)
    void userRequestDTOToEntity(UserRequestDTO userRequestDTO, @MappingTarget User user);
    
}
