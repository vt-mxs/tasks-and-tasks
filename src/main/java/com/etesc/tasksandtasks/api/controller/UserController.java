package com.etesc.tasksandtasks.api.controller;

import org.springframework.web.bind.annotation.RestController;
import com.etesc.tasksandtasks.api.dto.request.UserLoginRequestDTO;
import com.etesc.tasksandtasks.api.dto.request.UserRequestDTO;
import com.etesc.tasksandtasks.api.dto.response.UserResponseDTO;
import com.etesc.tasksandtasks.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> getMethodName(@RequestBody @Valid UserLoginRequestDTO request) {
        UserResponseDTO response = service.loginUser(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> postMethodName(@RequestBody @Valid UserRequestDTO request) {
        UserResponseDTO response = service.createUser(request);
        return ResponseEntity.ok(response);
    }
}
