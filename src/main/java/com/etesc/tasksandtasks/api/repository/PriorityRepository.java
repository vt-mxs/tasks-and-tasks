package com.etesc.tasksandtasks.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.etesc.tasksandtasks.model.Priority;

public interface PriorityRepository extends JpaRepository<Priority, Long> {

}
