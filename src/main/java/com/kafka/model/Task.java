package com.kafka.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.LastModifiedDate;

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

	
	@Column(name = "task_name", length = 100, nullable = false)
	private String taskName;
	
	@Column(name = "description", length = 255, nullable = false)
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private Status status;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "priority", nullable = false)
	private Priority priority;
	
	@Column(name = "assigned_at", nullable = false)
	private LocalDateTime assignedAt;	// Boş ise LocalDateTime.now()'dan gelecek. İŞ KATMANINDA
	
	@Column(name = "due_date", nullable = false)
	private LocalDateTime dueDate;
	
	@ManyToOne
	@JoinColumn(name = "assigned_by", nullable = false)
	private User assignedBy;
	
	@ManyToOne
	@JoinColumn(name = "updated_by")
	private User updatedBy;
	
    @LastModifiedDate
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}
