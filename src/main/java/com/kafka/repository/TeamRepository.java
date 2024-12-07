package com.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kafka.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

}
