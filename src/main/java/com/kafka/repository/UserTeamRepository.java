package com.kafka.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kafka.model.User;
import com.kafka.model.UserTeam;

@Repository
public interface UserTeamRepository extends JpaRepository<UserTeam, Long>{

	@Query(value = "from UserTeam")
	Page<UserTeam> findAllPageable(Pageable pageable);
}
