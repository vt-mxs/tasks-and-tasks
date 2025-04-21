package com.etesc.tasksandtasks.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etesc.tasksandtasks.api.dto.request.UserRequestDTO;
import com.etesc.tasksandtasks.api.dto.response.UserResponseDTO;
import com.etesc.tasksandtasks.api.service.UserService;

import jakarta.validation.Valid;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping("/get/{email}")
	public ResponseEntity<UserResponseDTO> getUserByEmail(@PathVariable String email){
		UserResponseDTO response = service.getUserByEmail(email);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO request){
		UserResponseDTO createdUser = service.createUser(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
}
