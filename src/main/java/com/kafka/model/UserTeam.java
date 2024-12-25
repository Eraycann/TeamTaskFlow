package com.kafka.model;

import jakarta.persistence.Column;
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
    name = "users_teams",
    uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "team_id", "role_id"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserTeam extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;
    
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
    
    @Column(name = "is_active", columnDefinition = "BOOLEAN DEFAULT true")	// Veritabanı seviyesinde
    private Boolean isActive = true;	// Uyg. seviyesinde
}
