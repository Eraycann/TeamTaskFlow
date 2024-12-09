package com.kafka.dto.request;

import java.time.LocalDateTime;

import com.kafka.enums.Priority;
import com.kafka.enums.Status;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequestDTO extends BaseRequestDTO{

	@NotEmpty(message = "Task name cannot be empty")
	@Size(min = 3, max = 100, message = "Task name must be between 3 and 100 characters")
	private String taskName;
	
    @NotEmpty(message = "Description cannot be empty")
    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;
	
    @NotNull(message = "Status cannot be null")
	private Status status;
	
    @NotNull(message = "Priority cannot be null")
	private Priority priority;
	
    @PastOrPresent(message = "Updated date must be in the past or present")
	private LocalDateTime assignedAt;
	
    @NotNull(message = "Due date cannot be null")
    @FutureOrPresent(message = "Due date must be a future or present date")
    private LocalDateTime dueDate;
	
    @NotNull(message = "Assigned by cannot be null")
	private Long assignedBy; // userId
	
	private Long updatedBy; // userId
	
	private LocalDateTime updatedAt;
}
