package com.etesc.tasksandtasks.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.etesc.tasksandtasks.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
