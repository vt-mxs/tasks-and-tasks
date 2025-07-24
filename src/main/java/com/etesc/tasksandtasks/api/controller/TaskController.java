package com.etesc.tasksandtasks.api.controller;
import org.springframework.web.bind.annotation.RestController;
import com.etesc.tasksandtasks.api.dto.request.TaskRequestDTO;
import com.etesc.tasksandtasks.api.dto.response.TaskResponseDTO;
import com.etesc.tasksandtasks.api.service.TaskService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public ResponseEntity<List<TaskResponseDTO>> getAllUserTasks(@RequestParam @Valid String email) {
        List<TaskResponseDTO> response = taskService.getAllUserTasks(email);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getById")
    public ResponseEntity<TaskResponseDTO> getTaskById(@RequestParam Long id) {
        TaskResponseDTO response = taskService.getTaskById(id);

        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<TaskResponseDTO> deleteTaskById(@PathVariable Long id) {
        TaskResponseDTO response = taskService.deletTask(id);
        return ResponseEntity.ok(response);
    }
    
}
