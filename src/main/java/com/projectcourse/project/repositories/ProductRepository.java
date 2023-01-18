package com.projectcourse.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectcourse.project.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
