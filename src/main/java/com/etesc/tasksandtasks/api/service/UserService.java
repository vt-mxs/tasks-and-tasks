package com.etesc.tasksandtasks.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etesc.tasksandtasks.api.dto.UserDTO;
import com.etesc.tasksandtasks.api.dto.response.UserResponseDTO;
import com.etesc.tasksandtasks.api.repository.UserRepository;
import com.etesc.tasksandtasks.model.User;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public UserResponseDTO createUser(UserDTO request) {
		User user = new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user = repository.save(user);
		
		return new UserResponseDTO(user.getId(), request.getName(), request.getEmail());
	}

	public UserResponseDTO loginUser(String email) {
		User user = repository.findByEmail(email)
					// TODO: implementar exception personalizada depois
					.orElseThrow(() -> new RuntimeException());
		return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
	}
}