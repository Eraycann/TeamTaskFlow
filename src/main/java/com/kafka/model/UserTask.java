package com.kafka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "users_tasks",
    uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "task_id_id", "role_id"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserTask extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;
    
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
