package com.projectcourse.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectcourse.project.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
