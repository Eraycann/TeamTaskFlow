package com.kafka.dto.response;

import java.time.LocalDateTime;

import com.kafka.enums.Priority;
import com.kafka.enums.Status;
import com.kafka.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponseDTO extends BaseResponseDTO{

	private String taskName;
	
	private String description;
	
	private Status status;
	
	private Priority priority;
	
	private LocalDateTime assignedAt;	// Boş ise LocalDateTime.now()'dan gelecek. İŞ KATMANINDA
	
	private LocalDateTime dueDate;
	
	private UserResponseDTO assignedBy;
	
	private UserResponseDTO updatedBy;
	
	private LocalDateTime updatedAt;
}
