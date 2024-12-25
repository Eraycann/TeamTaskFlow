package com.kafka.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kafka.model.Team;
import com.kafka.model.User;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

	@Query(value = "from Team")
	Page<Team> findAllPageable(Pageable pageable);
}
