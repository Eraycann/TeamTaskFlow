package com.kafka.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kafka.model.Role;
import com.kafka.model.User;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	@Query(value = "from Role")
	Page<Role> findAllPageable(Pageable pageable);
}
