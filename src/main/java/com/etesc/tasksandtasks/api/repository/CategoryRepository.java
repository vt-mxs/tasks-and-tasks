package com.etesc.tasksandtasks.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etesc.tasksandtasks.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
