package com.etesc.tasksandtasks.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etesc.tasksandtasks.api.dto.request.UserRequestDTO;
import com.etesc.tasksandtasks.api.dto.response.UserResponseDTO;
import com.etesc.tasksandtasks.api.repository.UserRepository;
import com.etesc.tasksandtasks.model.User;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public UserResponseDTO getUserByEmail(String email) {
		User user = repository.findByEmail(email)
					// TODO: implementar exception personalizada depois
					.orElseThrow(() -> new RuntimeException());
		return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
	}
	
	public UserResponseDTO createUser(UserRequestDTO request) {
		User user = new User();
		user.setName(request.name());
		user.setEmail(request.email());
		user = repository.save(user);
		
		return new UserResponseDTO(user.getId(), request.name(), request.email());
	}
}