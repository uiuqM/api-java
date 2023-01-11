package com.projectcourse.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectcourse.project.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
