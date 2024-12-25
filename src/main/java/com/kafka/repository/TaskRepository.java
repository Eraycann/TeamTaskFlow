package com.kafka.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kafka.model.Task;
import com.kafka.model.User;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

	@Query(value = "from Task")
	Page<Task> findAllPageable(Pageable pageable);
}
