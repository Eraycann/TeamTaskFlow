package com.kafka.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "teams")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Team extends BaseEntity{
	
	@Column(name = "team_name", length = 50, nullable = false)
	private String teamName;
	
	@ManyToOne
	@JoinColumn(name = "owner", nullable = false)
	private User owner;
}
