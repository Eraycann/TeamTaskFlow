package com.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kafka.model.UserTeam;

@Repository
public interface UserTeamRepository extends JpaRepository<UserTeam, Long>{

}