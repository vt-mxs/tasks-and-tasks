package com.etesc.tasksandtasks.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etesc.tasksandtasks.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
