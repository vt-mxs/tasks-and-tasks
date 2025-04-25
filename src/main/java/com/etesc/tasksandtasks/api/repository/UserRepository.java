package com.etesc.tasksandtasks.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.etesc.tasksandtasks.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
}
