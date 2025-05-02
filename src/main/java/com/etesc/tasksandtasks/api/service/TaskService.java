package com.etesc.tasksandtasks.api.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.etesc.tasksandtasks.api.dto.request.TaskRequestDTO;
import com.etesc.tasksandtasks.api.dto.request.UserEmailRequestDTO;
import com.etesc.tasksandtasks.api.dto.response.CategoryResponseDTO;
import com.etesc.tasksandtasks.api.dto.response.PriorityResponseDTO;
import com.etesc.tasksandtasks.api.dto.response.TaskResponseDTO;
import com.etesc.tasksandtasks.api.dto.response.UserResponseDTO;
import com.etesc.tasksandtasks.api.repository.CategoryRepository;
import com.etesc.tasksandtasks.api.repository.PriorityRepository;
import com.etesc.tasksandtasks.api.repository.TaskRepository;
import com.etesc.tasksandtasks.api.repository.UserRepository;
import com.etesc.tasksandtasks.model.Category;
import com.etesc.tasksandtasks.model.Task;
import com.etesc.tasksandtasks.model.User;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PriorityRepository priorityRepository;

    @Transactional
    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO){
        Task task = new Task();
        User user = userRepository.findByEmail(taskRequestDTO.userEmail()).get();
        String formatedCategoryName = Character.toUpperCase(taskRequestDTO.categoryName().charAt(0)) + taskRequestDTO.categoryName().substring(1);

        Category possibleCategory = categoryRepository.findByName(formatedCategoryName)
            .orElseGet(() -> {
                Category newCategory = new Category(formatedCategoryName);
                categoryRepository.save(newCategory);
                return newCategory;
            });

        task.setTitle(taskRequestDTO.title());
        task.setDescription(taskRequestDTO.description());
        task.setUser(user);
        task.setCompleted(false);
        task.setCategory(possibleCategory);
        task.setPriority(priorityRepository.findByLevel(taskRequestDTO.priorityLevel()).get());

        taskRepository.save(task);

        return new TaskResponseDTO(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getCompleted(),
            new UserResponseDTO(user.getId(), user.getName(), user.getEmail()),
            new CategoryResponseDTO(task.getCategory().getName()),
            new PriorityResponseDTO(task.getPriority().getLevel())
        );
    }

    @Transactional(readOnly = true)
    public List<TaskResponseDTO> getAllUserTasks(UserEmailRequestDTO userEmailRequestDTO){
        User user = userRepository.findByEmail(userEmailRequestDTO.email()).get();
        List<Task> tasks = taskRepository.findAllByUserId(user.getId());
        List<TaskResponseDTO> response = new ArrayList<>();
        tasks.forEach(task -> response.add(new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCompleted(),
                new UserResponseDTO(user.getId(), user.getName(), user.getEmail()),
                new CategoryResponseDTO(task.getCategory().getName()),
                new PriorityResponseDTO(task.getPriority().getLevel()))
            )
        );

        return response;
    }
}
