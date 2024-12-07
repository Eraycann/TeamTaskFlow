package com.kafka.model;

import java.time.LocalDateTime;

import com.kafka.enums.Priority;
import com.kafka.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task extends BaseEntity{

	
	@Column(name = "task_name")
	private String taskName;
	
	@Column(name = "description")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "priority")
	private Priority priority;
	
	@Column(name = "assigned_at")
	private LocalDateTime assignedAt;
	
	@Column(name = "due_date")
	private LocalDateTime dueDate;
	
	@ManyToOne
	@JoinColumn(name = "assigned_by")
	private User assignedBy;
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}
