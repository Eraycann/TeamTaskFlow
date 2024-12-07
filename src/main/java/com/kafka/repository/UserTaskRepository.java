package com.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kafka.model.UserTask;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTask, Long>{

}
