package com.projectcourse.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectcourse.project.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
