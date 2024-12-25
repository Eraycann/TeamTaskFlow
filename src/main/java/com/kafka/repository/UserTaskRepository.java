package com.kafka.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kafka.model.User;
import com.kafka.model.UserTask;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTask, Long>{

	@Query(value = "from UserTask")
	Page<UserTask> findAllPageable(Pageable pageable);
}
