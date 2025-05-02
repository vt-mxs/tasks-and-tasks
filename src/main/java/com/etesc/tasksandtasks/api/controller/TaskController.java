package com.etesc.tasksandtasks.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.etesc.tasksandtasks.api.dto.request.TaskRequestDTO;
import com.etesc.tasksandtasks.api.dto.request.UserEmailRequestDTO;
import com.etesc.tasksandtasks.api.dto.response.TaskResponseDTO;
import com.etesc.tasksandtasks.api.service.TaskService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody @Valid TaskRequestDTO dto) {
        TaskResponseDTO response = taskService.createTask(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<List<TaskResponseDTO>> getAllUserTasks(@RequestBody @Valid UserEmailRequestDTO dto) {
        List<TaskResponseDTO> response = taskService.getAllUserTasks(dto);

        return ResponseEntity.ok(response);
    }
    
}
