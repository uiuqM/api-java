package com.projectcourse.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectcourse.project.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}
